package com.vasanthan.event_booking_system.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookingRequestDTO {
    @NotNull(message = "Event ID is required")
    private Long eventId;

    @Min(value = 1, message = "Booked seats must be greater than 0")
    private int numberOfSeats;
}
