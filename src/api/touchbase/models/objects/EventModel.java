package api.touchbase.models.objects;

import java.util.List;

public class EventModel {
    private String id;
    private String ownerId;
    private String description;
    private String type;
    private String date;
    private String startTime;
    private String endTime;
    private List<String> attendingMemberNames;

    public EventModel() {

    }

    public String getId() {
        return id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public List<String> getAttendingMemberNames() {
        return attendingMemberNames;
    }

    public EventModel(Builder builder) {
        this.id = builder.id;
        this.ownerId = builder.ownerId;
        this.description = builder.description;
        this.type = builder.type;
        this.date = builder.date;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.attendingMemberNames = builder.attendingMemberNames;
    }
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "eventId='" + id + '\'' +
                ", eventOwnerId='" + ownerId + '\'' +
                ", eventDescription='" + description + '\'' +
                ", eventType='" + type + '\'' +
                ", eventDate='" + date + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String ownerId;
        private String description;
        private String type;
        private String date;
        private String startTime;
        private String endTime;
        private List<String> attendingMemberNames;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withOwnerId(String ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public Builder withAttendingMemberNames(List<String> attendingMemberNames) {
            this.attendingMemberNames = attendingMemberNames;
            return this;
        }

        public Builder withStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder withEndTime(String endTime) {
            this.endTime = endTime;
            return this;
        }


        public EventModel build() {
            return new EventModel(this);
        }
    }
}
