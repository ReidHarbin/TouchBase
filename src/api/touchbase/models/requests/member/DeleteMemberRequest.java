package api.touchbase.models.requests.member;

public class DeleteMemberRequest {
    private String id;
    private String password;
    private String name;

    public DeleteMemberRequest() {
    }

    public DeleteMemberRequest(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public DeleteMemberRequest(Builder builder) {
        this.id = builder.id;
        this.password = builder.password;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "DeleteMemberRequest{" +
                "memberId='" + id + '\'' +
                ", memberPassword='" + password + '\'' +
                ", memberName='" + name + '\'' +
                '}';
    }

    // Builder Class
    public static final class Builder {
        private String id;
        private String password;
        private String name;

        public Builder withMemberId(String id) {
            this.id = id;
            return this;
        }

        public Builder withMemberPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withMemberName(String name) {
            this.name = name;
            return this;
        }

        public DeleteMemberRequest build() {
            return new DeleteMemberRequest(this);
        }
    }
}
