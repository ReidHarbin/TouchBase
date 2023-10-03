package api.touchbase.models.results.member;

public class MemberLoginResult {
    private String id;
    private String familyId;

    public MemberLoginResult() {

    }

    public MemberLoginResult(String id) {
        this.id = id;
    }

    public MemberLoginResult(String id, String familyId) {
        this.id = id;
        this.familyId = familyId;
    }

    public MemberLoginResult(Builder builder) {
        this.id = builder.memberId;
        this.familyId = builder.memberFamilyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        private String memberId;
        private String memberFamilyId;

        public Builder withMemberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder withMemberFamilyId(String memberFamilyId) {
            this.memberFamilyId = memberFamilyId;
            return this;
        }

        public MemberLoginResult build() {
            return new MemberLoginResult(this);
        }
    }
}
