package api.touchbase.dynamodb.models;

public class Notification {
    private String headline;
    private String description;
    private String senderName;
    private String date;

    private Notification(Builder builder) {
        this.headline = builder.headline;
        this.description = builder.description;
        this.senderName = builder.senderName;
        this.date = builder.date;
    }

    public String getHeadline() {
        return headline;
    }

    public String getDescription() {
        return description;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getDate() {
        return date;
    }

    public static class Builder {
        private String headline;
        private String description;
        private String senderName;
        private String date;

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

        public Notification build() {
            return new Notification(this);
        }
    }
}
