package api.touchbase.models.objects;

import api.touchbase.dynamodb.models.Notification;

import java.util.List;

public class MemberModel {
    private String id;
    private String name;
    private List<NotificationModel> notifications;
    private String familyId;

    public MemberModel() {

    }

    public MemberModel(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.notifications = builder.notifications;
        this.familyId = builder.familyId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<NotificationModel> getNotifications() {
        return notifications;
    }

    public String getFamilyId() {
        return familyId;
    }

    @Override
    public String toString() {
        return "MemberModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String name;
        private String familyId;
        private List<NotificationModel> notifications;

        public Builder withId(String idToUse) {
            this.id = idToUse;
            return this;
        }

        public Builder withName(String nameToUse) {
            this.name = nameToUse;
            return this;
        }

        public Builder withNotifications(List<NotificationModel> notifications) {
            this.notifications = notifications;
            return this;
        }

        public Builder withFamilyId(String familyId) {
            this.familyId = familyId;
            return this;
        }
        public MemberModel build() {
            return new MemberModel(this);
        }
    }
}
