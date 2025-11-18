package com.example.demo.provider_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class EventsController {
    
@Autowired
private EventsService eventsService;

@GetMapping("/events")
public Object getAllEvents(Model model) {
    //return eventsService.getAllEvents();
    model.addAttribute("eventsList", eventsService.getAllEvents());
    return "event_dashboard"; //returns event_dashboard.ftlh
}
@GetMapping("/events/eventName")
public Object getEventByName(@RequestParam String eventName) {
    if (eventName != null) {
        return eventsService.getEventByName(eventName);
    } else {
        return eventsService.getAllEvents();
    }
}
@PostMapping("/events")
public Events addEvent (@RequestBody Events event) {
    return eventsService.addEvent(event);
}
@GetMapping("/events/{eventId}")
public Object deleteEvent(@PathVariable Long eventId) {
    eventsService.deleteEvent(eventId);
    return "redirect:/events";
}

}
