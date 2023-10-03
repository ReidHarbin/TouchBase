package api.touchbase.models.requests.family;

public class GetEventsRequest {
    private String familyId;
    private String memberId;

    public GetEventsRequest() {
    }

    public GetEventsRequest(String familyId) {
        this.familyId = familyId;
    }

    public GetEventsRequest(String familyId, String memberId) {
        this.familyId = familyId;
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public GetEventsRequest(Builder builder) {
        this.memberId = builder.memberId;
        this.familyId = builder.familyId;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String familyId;
        private String memberId;

        public Builder withFamilyId(String familyId) {
            this.familyId = familyId;
            return this;
        }

        public Builder withFamilyMemberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public GetEventsRequest build() {
            return new GetEventsRequest(this);
        }
    }
}
