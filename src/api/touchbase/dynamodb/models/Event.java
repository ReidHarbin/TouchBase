package api.touchbase.dynamodb.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public class Event {
    private String id;
    private String ownerId;
    private String description;
    private String type;
    private String eventStartMeridian;
    private String eventEndMeridian;
    private LocalDate eventDate;
    private LocalTime eventStartTime;
    private LocalTime eventEndTime;
    private List<String> attendingMemberNames;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEventStartMeridian() {
        return eventStartMeridian;
    }

    public void setEventStartMeridian(String eventStartMeridian) {
        this.eventStartMeridian = eventStartMeridian;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(LocalTime eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public LocalTime getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(LocalTime eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public List<String> getAttendingMemberNames() {
        return attendingMemberNames;
    }

    public void setAttendingMemberNames(List<String> attendingMemberNames) {
        this.attendingMemberNames = attendingMemberNames;
    }

    public String getEventEndMeridian() {
        return eventEndMeridian;
    }

    public void setEventEndMeridian(String eventEndMeridian) {
        this.eventEndMeridian = eventEndMeridian;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + id + '\'' +
                ", eventOwnerId='" + ownerId + '\'' +
                ", description='" + description + '\'' +
                ", eventType='" + type + '\'' +
                ", eventDate=" + eventDate +
                ", eventStartTime=" + eventStartTime +
                ", eventEndTime=" + eventEndTime +
                ", eventAttendingMemberIds=" + attendingMemberNames +
                '}';
    }
}
