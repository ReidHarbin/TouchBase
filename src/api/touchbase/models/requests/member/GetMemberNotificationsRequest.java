package api.touchbase.models.requests.member;

public class GetMemberNotificationsRequest {
    private String id;

    // Constructors
    public GetMemberNotificationsRequest() {

    }

    public GetMemberNotificationsRequest(String id) {
        this.id = id;
    }

    public GetMemberNotificationsRequest(Builder builder) {
        this.id = builder.id;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "GetMemberNotificationsRequest{" +
                "memberId='" + id + '\'' +
                '}';
    }

    // Builder class
    public static final class Builder {
        private String id;

        private Builder() {

        }

        public Builder withMemberId(String id) {
            this.id = id;
            return this;
        }

        public GetMemberNotificationsRequest build() {
            return new GetMemberNotificationsRequest(this);
        }
    }

}

