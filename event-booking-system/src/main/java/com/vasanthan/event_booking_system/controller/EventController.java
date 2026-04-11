package com.vasanthan.event_booking_system.controller;

import com.vasanthan.event_booking_system.dto.*;
import com.vasanthan.event_booking_system.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<EventResponseDTO> createEvent(@Valid @RequestBody EventRequestDTO request) {
        return new ResponseEntity<>(eventService.createEvent(request), HttpStatus.CREATED);
    }

    @GetMapping
    public List<EventResponseDTO> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public EventResponseDTO getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
