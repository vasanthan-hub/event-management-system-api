package com.vasanthan.event_booking_system.service;


import com.vasanthan.event_booking_system.dto.*;
import com.vasanthan.event_booking_system.entity.*;
import com.vasanthan.event_booking_system.exception.*;
import com.vasanthan.event_booking_system.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final EventRepository eventRepository;

    @Transactional
    public BookingResponseDTO createBooking(BookingRequestDTO request) {
        Event event = eventRepository.findById(request.getEventId())
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + request.getEventId()));

        if (request.getNumberOfSeats() > event.getAvailableSeats()) {
            throw new OverbookingException("Not enough seats available. Remaining: " + event.getAvailableSeats());
        }

        event.setAvailableSeats(event.getAvailableSeats() - request.getNumberOfSeats());
        eventRepository.save(event);

        Booking booking = Booking.builder()
                .event(event)
                .numberOfSeats(request.getNumberOfSeats())
                .bookingTime(LocalDateTime.now())
                .build();

        Booking saved = bookingRepository.save(booking);
        return mapToResponse(saved);
    }

    public List<BookingResponseDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream().map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public BookingResponseDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        return mapToResponse(booking);
    }

    private BookingResponseDTO mapToResponse(Booking b) {
        return BookingResponseDTO.builder()
                .id(b.getId())
                .eventId(b.getEvent().getId())
                .eventName(b.getEvent().getName())
                .numberOfSeats(b.getNumberOfSeats())
                .bookingTime(b.getBookingTime())
                .build();
    }
}
