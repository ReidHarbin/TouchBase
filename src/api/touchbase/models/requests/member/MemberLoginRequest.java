package api.touchbase.models.requests.member;

public class MemberLoginRequest {
    private String name;
    private String password;

    public MemberLoginRequest() {

    }

    public MemberLoginRequest(String memberName, String memberPassword) {
        this.name = memberName;
        this.password = memberPassword;
    }

    public MemberLoginRequest(Builder builder) {
        this.name = builder.name;
        this.password = builder.password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private String password;

        public Builder withMemberName(String name) {
            this.name = name;
            return this;
        }

        public Builder withMemberPassword(String password) {
            this.password = password;
            return this;
        }

        public MemberLoginRequest build(){
            return new MemberLoginRequest(this);
        }
    }
}
