package api.touchbase.activity.family;

import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.FamilyDao;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.*;
import api.touchbase.models.requests.family.CreateFamilyRequest;
import api.touchbase.models.results.family.CreateFamilyResult;
import api.touchbase.utils.AccessCodeGenerator;
import api.touchbase.utils.TouchBaseIdGenerator;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;
import java.util.*;

public class CreateFamilyActivity implements RequestHandler<CreateFamilyRequest, CreateFamilyResult> {
    private final FamilyDao familyDao;
    private final MemberDao memberDao;

    @Inject
    public CreateFamilyActivity(FamilyDao familyDao, MemberDao memberDao) {
        this.familyDao = familyDao;
        this.memberDao = memberDao;
    }

    @Override
    public CreateFamilyResult handleRequest(final CreateFamilyRequest createFamilyRequest, Context context) {
        String requestName = createFamilyRequest.getName();
        String requestCreatorId = createFamilyRequest.getCreatorId();

        Member creator = memberDao.getMember(requestCreatorId);

        if (creator.getFamilyId() != null) {
            throw new MemberHasFamilyException("You need to leave your current family before you can create a new one");
        }
        if (requestName == null || requestName.isBlank()) {
            throw new InvalidInputException("You must provide a name for your family");
        }

        Map<String, String> memberNamesToMemberIds = new HashMap<>();
        memberNamesToMemberIds.put(creator.getName(), requestCreatorId);

        Family familyToCreate = new Family();
        familyToCreate.setId(TouchBaseIdGenerator.generateId());
        familyToCreate.setAccessCode(AccessCodeGenerator.generateAccessCode());
        familyToCreate.setName(requestName);
        familyToCreate.setNamesToMemberIds(memberNamesToMemberIds);
        familyToCreate.setEvents(new ArrayList<>());

        creator.setFamilyId(familyToCreate.getId());

        familyDao.save(familyToCreate);
        memberDao.saveMember(creator);

        return CreateFamilyResult.builder()
                .withFamilyModel(ModelConverter.toFamilyModel(familyToCreate))
                .build();
    }
}
