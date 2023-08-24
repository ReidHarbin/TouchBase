package api.touchbase.dynamodb.models;

import api.touchbase.converters.EventsListConverter;
import api.touchbase.converters.MapConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.List;
import java.util.Map;

@DynamoDBTable(tableName = "touchbase_families")
public class Family {
    private String id;
    private String name;
    private String password;
    private String salt;
    private List<Event> events;
    private Map<String, String> memberNamesToMemberIds;

    @DynamoDBHashKey(attributeName = "familyId")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "FamilyNameIndex", attributeName = "familyName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "familyPassword")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @DynamoDBAttribute(attributeName = "familyPasswordSalt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @DynamoDBTypeConverted(converter = EventsListConverter.class)
    @DynamoDBAttribute(attributeName = "familyEvents")
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> familyEventIds) {
        this.events = familyEventIds;
    }

    @DynamoDBTypeConverted(converter = MapConverter.class)
    @DynamoDBAttribute(attributeName = "familyMemberNamesToMemberIds")
    public Map<String, String> getMemberNamesToMemberIds() {
        return memberNamesToMemberIds;
    }

    public void setMemberNamesToMemberIds(Map<String, String> memberNamesToMemberIds) {
        this.memberNamesToMemberIds = memberNamesToMemberIds;
    }
}
