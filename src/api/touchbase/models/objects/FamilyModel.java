package api.touchbase.models.objects;

import api.touchbase.dynamodb.models.Event;

import java.util.List;

public class FamilyModel {
    private String id;
    private String name;
    private List<String> memberNames;

    public FamilyModel() {

    }

    public FamilyModel(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.memberNames = builder.memberNames;
    }

    @Override
    public String toString() {
        return "FamilyModel{" +
                "familyId='" + id + '\'' +
                ", familyName='" + name + '\'' +
                ", familyEventDescriptions=" + memberNames +
                '}';
    }
    public static Builder builder() {
            return new Builder();
        }

    public static final class Builder {
        private String id;
        private String name;
        private List<String> memberNames;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withMemberNames(List<String> memberNames) {
            this.memberNames = memberNames;
            return this;
        }

        public FamilyModel build() {
            return new FamilyModel(this);
        }
    }
}
