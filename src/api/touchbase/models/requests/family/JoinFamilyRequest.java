package api.touchbase.models.requests.family;

public class JoinFamilyRequest {
    private String memberId;
    private String accessCode;
    private String familyName;

    public JoinFamilyRequest() {

    }

    public JoinFamilyRequest(String familyName, String memberId, String familyPassword) {
        this.familyName = familyName;
        this.memberId = memberId;
        this.accessCode = familyPassword;

    }

    public JoinFamilyRequest(Builder builder) {
        this.memberId = builder.memberId;
        this.accessCode = builder.familyPassword;
        this.familyName = builder.familyName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private String memberId;
        private String familyPassword;
        private String familyName;

        public Builder withMemberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder withFamilyPassword(String familyPassword) {
            this.familyPassword = familyPassword;
            return this;
        }

        public Builder withFamilyName(String familyName) {
            this.familyName = familyName;
            return this;
        }

        public JoinFamilyRequest build() {
            return new JoinFamilyRequest(this);
        }
    }
}
