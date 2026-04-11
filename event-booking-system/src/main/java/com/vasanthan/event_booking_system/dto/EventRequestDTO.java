package com.vasanthan.event_booking_system.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventRequestDTO {
    @NotBlank(message = "Event name is required")
    private String name;

    private String location;

    private LocalDateTime eventDate;

    @Min(value = 1, message = "Total seats must be greater than 0")
    private int totalSeats;
}
