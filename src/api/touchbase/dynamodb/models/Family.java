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
    private String accessCode;
    private List<Event> events;
    private Map<String, String> memberNamesToMemberIds;

    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "FamilyNameIndex", attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBIndexRangeKey(attributeName = "accessCode")
    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
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
    @DynamoDBAttribute(attributeName = "namesToMemberIds")
    public Map<String, String> getNamesToMemberIds() {
        return memberNamesToMemberIds;
    }

    public void setNamesToMemberIds(Map<String, String> memberNamesToMemberIds) {
        this.memberNamesToMemberIds = memberNamesToMemberIds;
    }
}
