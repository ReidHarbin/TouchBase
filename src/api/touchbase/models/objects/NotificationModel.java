package api.touchbase.models.objects;

public class NotificationModel {
    private String headline;
    private String description;
    private String senderName;
    private String date;

    public NotificationModel() {

    }

    public NotificationModel(Builder builder) {
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

        public NotificationModel build() {
            return new NotificationModel(this);
        }
    }
}

