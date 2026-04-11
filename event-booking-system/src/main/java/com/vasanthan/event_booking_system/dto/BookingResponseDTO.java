package com.vasanthan.event_booking_system.dto;


import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class BookingResponseDTO {
    private Long id;
    private Long eventId;
    private String eventName;
    private int numberOfSeats;
    private LocalDateTime bookingTime;
}
