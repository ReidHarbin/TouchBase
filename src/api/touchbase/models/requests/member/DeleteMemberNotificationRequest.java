package api.touchbase.models.requests.member;

public class DeleteMemberNotificationRequest {
    private String id;
    private int notificationIndex;

    // Constructors
    public DeleteMemberNotificationRequest() {
    }

    public DeleteMemberNotificationRequest(String id, int notificationIndex) {
        this.id = id;
        this.notificationIndex = notificationIndex;
    }

    public DeleteMemberNotificationRequest(Builder builder) {
        this.id = builder.id;
        this.notificationIndex = builder.notificationIndex;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public int getNotificationIndex() {
        return notificationIndex;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNotificationIndex(int notificationIndex) {
        this.notificationIndex = notificationIndex;
    }

    // Builder Constructor
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "DeleteMemberNotificationRequest{" +
                "memberId='" + id + '\'' +
                ", memberNotificationIndex=" + notificationIndex +
                '}';
    }

    // Builder class
    public static final class Builder {
        private String id;
        private int notificationIndex;

        public Builder withMemberId(String id) {
            this.id = id;
            return this;
        }

        public Builder withMemberNotificationIndex(int notificationIndex) {
            this.notificationIndex = notificationIndex;
            return this;
        }

        public DeleteMemberNotificationRequest build() {
            return new DeleteMemberNotificationRequest(this);
        }
    }
}

