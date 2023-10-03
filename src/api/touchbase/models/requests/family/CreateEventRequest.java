package api.touchbase.models.requests.family;

import java.util.List;

public class CreateEventRequest {
    private String familyId;
    private String ownerName;
    private String type;
    private String date;
    private String startMeridian;
    private String endMeridian;
    private String startTime;
    private String endTime;
    private String description;
    private List<String> attendingMemberNames;

    public CreateEventRequest() {
    }

    public CreateEventRequest(String familyId, String ownerId, String type, String date,
                         String startTime, String endTime, String description,
                         List<String> attendingMemberNames) {
        this.familyId = familyId;
        this.ownerName = ownerId;
        this.type = type;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.attendingMemberNames = attendingMemberNames;
    }

    public CreateEventRequest(Builder builder){
        this.familyId = builder.familyId;
        this.ownerName = builder.ownerName;
        this.description = builder.description;
        this.type = builder.type;
        this.date = builder.date;
        this.startMeridian = builder.startMeridian;
        this.endMeridian = builder.endMeridian;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.attendingMemberNames = builder.attendingMemberNames;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartMeridian() {
        return startMeridian;
    }

    public void setStartMeridian(String startMeridian) {
        this.startMeridian = startMeridian;
    }

    public String getEndMeridian() {
        return endMeridian;
    }

    public void setEndMeridian(String endMeridian) {
        this.endMeridian = endMeridian;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public List<String> getAttendingMemberNames() {
        return attendingMemberNames;
    }

    public void setAttendingMemberNames(List<String> attendingMemberNames) {
        this.attendingMemberNames = attendingMemberNames;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String familyId;
        private String ownerName;
        private String description;
        private String type;
        private String date;
        private String startMeridian;
        private String endMeridian;
        private String startTime;
        private String endTime;
        private List<String> attendingMemberNames;

        public Builder withFamilyId(String familyId) {
            this.familyId = familyId;
            return this;
        }

        public Builder withOwnerName(String ownerName) {
            this.ownerName = ownerName;
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

        public Builder withStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder withEndTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder withStartMeridian(String startMeridian) {
            this.startMeridian = startMeridian;
            return this;
        }

        public Builder withEndMeridian(String endMeridian) {
            this.endMeridian = endMeridian;
            return this;
        }

        public Builder withAttendingMemberNames(List<String> attendingMemberNames) {
            this.attendingMemberNames = attendingMemberNames;
            return this;
        }

        public CreateEventRequest build() {
            return new CreateEventRequest(this);
        }
    }
}
