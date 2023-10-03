package api.touchbase.dynamodb.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Event {
    private String id;
    private String ownerId;
    private String description;
    private String type;
    private String startMeridian;
    private String endMeridian;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
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

    public String getStartMeridian() {
        return startMeridian;
    }

    public void setStartMeridian(String startMeridian) {
        this.startMeridian = startMeridian;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public List<String> getAttendingMemberNames() {
        return attendingMemberNames;
    }

    public void setAttendingMemberNames(List<String> attendingMemberNames) {
        this.attendingMemberNames = attendingMemberNames;
    }

    public String getEndMeridian() {
        return endMeridian;
    }

    public void setEndMeridian(String endMeridian) {
        this.endMeridian = endMeridian;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + id + '\'' +
                ", eventOwnerId='" + ownerId + '\'' +
                ", description='" + description + '\'' +
                ", eventType='" + type + '\'' +
                ", eventDate=" + date +
                ", eventStartTime=" + startTime +
                ", eventEndTime=" + endTime +
                ", eventAttendingMemberIds=" + attendingMemberNames +
                '}';
    }
}
