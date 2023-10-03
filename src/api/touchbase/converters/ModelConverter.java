package api.touchbase.converters;

import api.touchbase.dynamodb.models.Notification;
import api.touchbase.dynamodb.models.Event;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.models.objects.EventModel;
import api.touchbase.models.objects.FamilyModel;
import api.touchbase.models.objects.MemberModel;
import api.touchbase.models.objects.NotificationModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ModelConverter {
    public ModelConverter() {

    }

    public static MemberModel toMemberModel(Member member) {
        List<NotificationModel> notificationModels = new ArrayList<>();
        member.getMemberNotifications().forEach(n -> notificationModels.add(toNotificationModel(n)));

        return MemberModel.builder()
                .withId(member.getId())
                .withName(member.getName())
                .withNotifications(notificationModels)
                .withFamilyId(member.getFamilyId())
                .build();
    }

    public static FamilyModel toFamilyModel(Family family) {
        List<String> memberNames = new ArrayList<>();
        for (String name : family.getNamesToMemberIds().keySet()) {
            memberNames.add(name);
        }
        return FamilyModel.builder()
                .withId(family.getId())
                .withName(family.getName())
                .withAccessCode(family.getAccessCode())
                .withMemberNames(memberNames)
                .build();
    }


    public static NotificationModel toNotificationModel(Notification notification) {
        return NotificationModel.builder()
                .withId(notification.getId())
                .withHeadline(notification.getHeadline())
                .withDescription(notification.getDescription())
                .withSenderName(notification.getSenderName())
                .withDate(notification.getDate())
                .build();
    }


    public static EventModel toEventModel(Event event) {
        System.out.println(event);
        LocalDate eventDate = event.getDate();
        LocalTime eventStartTime = event.getStartTime();
        LocalTime eventEndTime = event.getEndTime();

        String startMins = eventStartTime.getMinute() < 10 ?
                ("0" + eventStartTime.getMinute()) : Integer.toString(eventStartTime.getMinute());
        String endMins = eventEndTime.getMinute() < 10 ?
                ("0" + eventEndTime.getMinute()) : Integer.toString(eventEndTime.getMinute());

        String eventDateString =
                eventDate.getMonthValue() + "/" + eventDate.getDayOfMonth() + "/" + eventDate.getYear();

        String eventStartTimeString =
                eventStartTime.getHour() + ":" + startMins + " " + event.getStartMeridian();

        String eventEndTimeString =
                eventEndTime.getHour() + ":" + endMins + " " + event.getEndMeridian();

        return EventModel.builder()
                .withOwnerId(event.getOwnerId())
                .withId(event.getId())
                .withDate(eventDateString)
                .withDescription(event.getDescription())
                .withType(event.getType())
                .withStartTime(eventStartTimeString)
                .withEndTime(eventEndTimeString)
                .withAttendingMemberNames(event.getAttendingMemberNames())
                .build();
    }


}
