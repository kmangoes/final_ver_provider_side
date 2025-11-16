package com.example.demo.provider_cases.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.provider_cases.Events;
import com.example.demo.provider_cases.EventsService;

@Controller
public class EventsController {
    
@Autowired
private EventsService eventsService;

@GetMapping("/events")
public Object getAllEvents() {
    return eventsService.getAllEvents();
}
@GetMapping("/events/{eventId}")
public Object getEventById(@PathVariable Long eventId) {
    return eventsService.getEventById(eventId);
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
@DeleteMapping("/events/{eventId}")
public void deleteEvent(@PathVariable Long eventId) {
    eventsService.deleteEvent(eventId);
}

}
