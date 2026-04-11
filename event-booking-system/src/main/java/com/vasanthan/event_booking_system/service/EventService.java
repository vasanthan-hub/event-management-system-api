package com.vasanthan.event_booking_system.service;


import com.vasanthan.event_booking_system.dto.*;
import com.vasanthan.event_booking_system.entity.Event;
import com.vasanthan.event_booking_system.exception.ResourceNotFoundException;
import com.vasanthan.event_booking_system.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public EventResponseDTO createEvent(EventRequestDTO request) {
        Event event = Event.builder()
                .name(request.getName())
                .location(request.getLocation())
                .eventDate(request.getEventDate())
                .totalSeats(request.getTotalSeats())
                .availableSeats(request.getTotalSeats())
                .createdAt(LocalDateTime.now())
                .build();

        Event saved = eventRepository.save(event);
        return mapToResponse(saved);
    }

    public List<EventResponseDTO> getAllEvents() {
        return eventRepository.findAll()
                .stream().map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public EventResponseDTO getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        return mapToResponse(event);
    }

    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id))
            throw new ResourceNotFoundException("Event not found with id: " + id);
        eventRepository.deleteById(id);
    }

    private EventResponseDTO mapToResponse(Event e) {
        return EventResponseDTO.builder()
                .id(e.getId())
                .name(e.getName())
                .location(e.getLocation())
                .eventDate(e.getEventDate())
                .totalSeats(e.getTotalSeats())
                .availableSeats(e.getAvailableSeats())
                .createdAt(e.getCreatedAt())
                .build();
    }
}
