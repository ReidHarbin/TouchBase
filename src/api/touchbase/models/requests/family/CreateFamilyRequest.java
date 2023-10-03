package api.touchbase.models.requests.family;

public class CreateFamilyRequest {
    private String creatorId;
    private String name;

    public CreateFamilyRequest() {

    }

    public CreateFamilyRequest(String creatorId, String name) {
        this.creatorId = creatorId;
        this.name = name;
    }

    public CreateFamilyRequest(Builder builder) {
        this.creatorId = builder.creatorId;
        this.name = builder.name;
    }

    public Builder builder() {
        return new Builder();
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class Builder {
        private String creatorId;
        private String name;

        public Builder withFamilyCreatorId(String creatorId) {
            this.creatorId = creatorId;
            return this;
        }
        public Builder withFamilyName(String name) {
            this.name = name;
            return this;
        }
        public CreateFamilyRequest build() {
            return new CreateFamilyRequest(this);
        }
    }
}
