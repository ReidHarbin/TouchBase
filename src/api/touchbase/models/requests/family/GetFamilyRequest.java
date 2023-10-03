package api.touchbase.models.requests.family;

public class GetFamilyRequest {
    private String id;

    public GetFamilyRequest() {
    }

    public GetFamilyRequest(String id) {
        this.id = id;
    }

    public GetFamilyRequest(Builder builder) {
        this.id = builder.id;
    }

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
        return "GetFamilyRequest{" +
                "familyId='" + id + '\'' +
                '}';
    }

    public static final class Builder {
        private String id;

        private Builder() {

        }

        public Builder withFamilyId(String id) {
            this.id = id;
            return this;
        }

        public GetFamilyRequest build() {
            return new GetFamilyRequest(this);
        }
    }
}
