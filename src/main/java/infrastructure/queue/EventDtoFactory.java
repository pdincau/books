package infrastructure.queue;

import domain.events.Event;

public class EventDtoFactory {

    public static EventDto createFrom(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setType(event.getClass().getSimpleName());
        return eventDto;
    }
}
