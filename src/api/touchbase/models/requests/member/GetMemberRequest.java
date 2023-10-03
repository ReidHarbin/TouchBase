package api.touchbase.models.requests.member;

public class GetMemberRequest {
    private String id;

    public GetMemberRequest() {
    }

    public GetMemberRequest(String id) {
        this.id = id;
    }

    public GetMemberRequest(Builder builder) {
        this.id = builder.id;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "GetMemberDetailsRequest{" +
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

        public GetMemberRequest build() {
            return new GetMemberRequest(this);
        }
    }
}
