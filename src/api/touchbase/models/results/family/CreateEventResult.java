package api.touchbase.models.results.family;

import api.touchbase.models.objects.EventModel;
import api.touchbase.models.objects.FamilyModel;

import java.util.List;

public class CreateEventResult {
    private List<EventModel> events;

    public CreateEventResult() {

    }

    public CreateEventResult(List<EventModel> events) {
        this.events = events;
    }

    public CreateEventResult(Builder builder) {
        this.events = builder.events;
    }

    public List<EventModel> getEvents() {
        return events;
    }

    public void setEvents(List<EventModel> events) {
        this.events = events;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<EventModel> events;

        public Builder withEvents(List<EventModel> events) {
            this.events = events;
            return this;
        }

        public CreateEventResult build() {
            return new CreateEventResult(this);
        }
    }
}
