package api.touchbase.dynamodb.models;

import api.touchbase.converters.NotificationsListConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.List;

@DynamoDBTable(tableName = "touchbase-members")
public class Member {
    private String id;
    private String familyId;
    private String username;
    private String password;
    private String salt;
    private List<Notification> notifications;

    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "familyId")
    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "MemberUsernameIndex", attributeName = "username")
    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    @DynamoDBAttribute(attributeName = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @DynamoDBAttribute(attributeName = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    @DynamoDBTypeConverted(converter = NotificationsListConverter.class)
    @DynamoDBAttribute(attributeName = "notifications")
    public List<Notification> getMemberNotifications() {
        return notifications;
    }

    public void setMemberNotifications(List<Notification> memberNotifications) {
        this.notifications = memberNotifications;
    }
}
