package api.touchbase.dynamodb.models;

public class Notification {
    private String id;
    private String headline;
    private String description;
    private String senderName;
    private String date;

    public Notification(Builder builder) {
        this.id = builder.id;
        this.headline = builder.headline;
        this.description = builder.description;
        this.senderName = builder.senderName;
        this.date = builder.date;
    }

    public String getHeadline() {
        return this.headline;
    }

    public String getDescription() {
        return this.description;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String headline;
        private String description;
        private String senderName;
        private String date;
        private String id;

        public Builder withHeadline(String headline) {
            this.headline = headline;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withSenderName(String senderName) {
            this.senderName = senderName;
            return this;
        }

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }
        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
