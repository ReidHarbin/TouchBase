package api.touchbase.models.objects;

import java.util.Set;

public class EventModel {
    private String eventId;
    private String eventOwnerId;
    private String eventDescription;
    private String eventType;
    private String eventDate;
    private String eventStartTime;
    private String eventEndTime;
    private Set<String> eventAttendingMemberNames;

    public EventModel() {

    }

    public EventModel(Builder builder) {
        this.eventId = builder.eventId;
        this.eventOwnerId = builder.eventOwnerId;
        this.eventDescription = builder.eventDescription;
        this.eventType = builder.eventType;
        this.eventDate = builder.eventDate;
        this.eventStartTime = builder.eventStartTime;
        this.eventEndTime = builder.eventEndTime;
        this.eventAttendingMemberNames = builder.eventAttendingMemberNames;
    }
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "eventId='" + eventId + '\'' +
                ", eventOwnerId='" + eventOwnerId + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventDate='" + eventDate + '\'' +
                '}';
    }

    public static class Builder {
        private String eventId;
        private String eventOwnerId;
        private String eventDescription;
        private String eventType;
        private String eventDate;
        private String eventStartTime;
        private String eventEndTime;
        private Set<String> eventAttendingMemberNames;

        public Builder withEventId(String eventId) {
            this.eventId = eventId;
            return this;
        }
        public Builder withOwnerId(String eventOwnerId) {
            this.eventOwnerId = eventOwnerId;
            return this;
        }
        public Builder withEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
            return this;
        }
        public Builder withEventType(String eventType) {
            this.eventType = eventType;
            return this;
        }
        public Builder withEventDate(String eventDate) {
            this.eventDate = eventDate;
            return this;
        }

        public Builder withEventAttendingMemberNames(Set<String> eventFamilyMemberNames) {
            this.eventAttendingMemberNames = eventFamilyMemberNames;
            return this;
        }

        public Builder withEventStartTime(String eventStartTime) {
            this.eventStartTime = eventStartTime;
            return this;
        }

        public Builder withEventEndTime(String eventEndTime) {
            this.eventEndTime = eventEndTime;
            return this;
        }

        public EventModel build() {
            return new EventModel(this);
        }
    }
}
