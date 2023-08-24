package api.touchbase.utils;

import api.touchbase.dynamodb.models.Notification;
import api.touchbase.converters.LocalDateConverter;
import api.touchbase.dynamodb.models.Event;

import java.time.LocalDate;

public class NotificationCreator {
    private LocalDateConverter dateConverter = new LocalDateConverter();
    public NotificationCreator() {

    }

    public Notification newFamilyMemberNotification(String newMemberName) {
        return new Notification.Builder()
                .withHeadline("NEW FAMILY MEMBER!")
                .withDescription(String.format("%s has joined your family!", newMemberName))
                .withSenderName(newMemberName)
                .withDate(dateConverter.convert(LocalDate.now()))
                .build();
    }

    public Notification touchbaseNewMemberNotification() {
        return new Notification.Builder()
                .withHeadline("Welcome!")
                .withDescription("Welcome to TouchBase! No matter how far from home, you'll always be able to touchbase!")
                .withSenderName("TouchBase")
                .withDate(dateConverter.convert(LocalDate.now()))
                .build();
    }

    public Notification addedToEventNotification(String eventType, String eventDescription, String senderName) {
        return new Notification.Builder()
                .withHeadline("SENDER NAME ADDED YOU TO AN EVENT")
                .withDescription(eventDescription)
                .withSenderName(senderName)
                .withDate(dateConverter.convert(LocalDate.now()))
                .build();
    }

    public Notification familyMemberJoinedEventNotification(Event event, String senderName) {
        LocalDate eventDate = event.getEventDate();
        int year = eventDate.getYear();
        int month = eventDate.getMonthValue();
        int day = eventDate.getDayOfMonth();

        return new Notification.Builder()
                .withHeadline(senderName + " Has Joined Your Event")
                .withDescription("The event is for " + event.getType() + " on " + month + "/" + day + "/" + year)
                .withSenderName(senderName)
                .withDate(dateConverter.convert(LocalDate.now()))
                .build();
    }

}
