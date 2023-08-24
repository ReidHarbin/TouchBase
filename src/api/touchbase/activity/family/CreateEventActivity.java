package api.touchbase.activity.family;

import api.touchbase.converters.LocalDateConverter;
import api.touchbase.converters.LocalTimeConverter;
import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.FamilyDao;
import api.touchbase.dynamodb.models.Event;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.models.objects.FamilyModel;
import api.touchbase.models.requests.family.CreateEventRequest;
import api.touchbase.models.results.family.CreateEventResult;
import api.touchbase.utils.EventInserter;
import api.touchbase.utils.TouchBaseIdGenerator;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CreateEventActivity implements RequestHandler<CreateEventRequest, CreateEventResult> {
    private final FamilyDao familyDao;

    @Inject
    public CreateEventActivity(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    @Override
    public CreateEventResult handleRequest(final CreateEventRequest createEventRequest, Context context) {
        LocalTimeConverter timeConverter = new LocalTimeConverter();
        LocalDateConverter dateConverter = new LocalDateConverter();

        String requestFamilyId = createEventRequest.getFamilyId();
        String requestOwnerId = createEventRequest.getEventOwnerName();
        String requestType = createEventRequest.getEventType();
        String requestDescription = createEventRequest.getDescription();
        LocalDate requestDate = dateConverter.unconvert(createEventRequest.getEventDate());
        String requestStartMeridian = createEventRequest.getEventStartMeridian();
        String requestEndMeridian = createEventRequest.getEventEndMeridian();
        LocalTime requestStartTime = timeConverter.unconvert(createEventRequest.getEventStartTime());
        LocalTime requestEndTime = timeConverter.unconvert(createEventRequest.getEventEndTime());
        List<String> requestAttendingMembers = createEventRequest.getEventAttendingMemberNames();

        if (requestEndTime.isBefore(requestStartTime)) {
            throw new InvalidInputException("The ending time for the event cannot be before the starting time");
        }
        if (requestDate.isBefore(LocalDate.now())) {
            throw new InvalidInputException("Cannot set the event date to a day that has already passed");
        }
        if (requestOwnerId == null) {
            throw new InvalidInputException("Request ownerId cannot be null");
        }
        if (requestFamilyId == null) {
            throw new InvalidInputException("FamilyId cannot be null");
        }

        Family family = familyDao.getFamily(requestFamilyId);
        List<Event> familyEvents = family.getEvents();

        Event eventToCreate = new Event();
        eventToCreate.setId(TouchBaseIdGenerator.generateId());
        eventToCreate.setOwnerId(requestOwnerId);
        eventToCreate.setType(requestType);
        eventToCreate.setEventDate(requestDate);
        eventToCreate.setEventStartMeridian(requestStartMeridian);
        eventToCreate.setEventEndMeridian(requestEndMeridian);
        eventToCreate.setEventStartTime(requestStartTime);
        eventToCreate.setEventEndTime(requestEndTime);

        List<String> eventAttendingMembers = new ArrayList<>();


        if (requestAttendingMembers != null) {
            eventAttendingMembers.addAll(requestAttendingMembers);
        }

        eventToCreate.setAttendingMemberNames(eventAttendingMembers);

        eventToCreate.setDescription(requestDescription);

        familyEvents.add(EventInserter.insertEvent(familyEvents, requestDate, requestStartTime,
            requestStartMeridian), eventToCreate);


        family.setEvents(familyEvents);

        familyDao.save(family);
        FamilyModel familyModel = ModelConverter.toFamilyModel(family);

        return CreateEventResult.builder()
                .withFamilyModel(familyModel)
                .build();
    }
}
