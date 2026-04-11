package com.vasanthan.event_booking_system.dto;



import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class EventResponseDTO {
    private Long id;
    private String name;
    private String location;
    private LocalDateTime eventDate;
    private int totalSeats;
    private int availableSeats;
    private LocalDateTime createdAt;
}
