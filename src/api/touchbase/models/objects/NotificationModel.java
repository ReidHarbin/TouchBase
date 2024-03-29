package api.touchbase.models.objects;

import api.touchbase.dynamodb.models.Notification;

public class NotificationModel {
    private String id;
    private String headline;
    private String description;
    private String senderName;
    private String date;

    public NotificationModel() {

    }

    public NotificationModel(Builder builder) {
        this.id = builder.id;
        this.headline = builder.headline;
        this.description = builder.description;
        this.senderName = builder.senderName;
        this.date = builder.date;
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return "NotificationModel{" +
                "headline='" + headline + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
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

        public NotificationModel build() {
            return new NotificationModel(this);
        }
    }
}

