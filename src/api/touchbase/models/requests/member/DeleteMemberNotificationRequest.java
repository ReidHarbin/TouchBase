package api.touchbase.models.requests.member;

public class DeleteMemberNotificationRequest {
    private String id;
    private int memberNotificationIndex;

    // Constructors
    public DeleteMemberNotificationRequest() {
    }

    public DeleteMemberNotificationRequest(String id, int memberNotificationIndex) {
        this.id = id;
        this.memberNotificationIndex = memberNotificationIndex;
    }

    public DeleteMemberNotificationRequest(Builder builder) {
        this.id = builder.memberId;
        this.memberNotificationIndex = builder.memberNotificationIndex;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public int getMemberNotificationIndex() {
        return memberNotificationIndex;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMemberNotificationIndex(int memberNotificationIndex) {
        this.memberNotificationIndex = memberNotificationIndex;
    }

    // Builder Constructor
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "DeleteMemberNotificationRequest{" +
                "memberId='" + id + '\'' +
                ", memberNotificationIndex=" + memberNotificationIndex +
                '}';
    }

    // Builder class
    public static final class Builder {
        private String memberId;
        private int memberNotificationIndex;

        public Builder withMemberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder withMemberNotificationIndex(int memberNotificationIndex) {
            this.memberNotificationIndex = memberNotificationIndex;
            return this;
        }

        public DeleteMemberNotificationRequest build() {
            return new DeleteMemberNotificationRequest(this);
        }
    }
}

