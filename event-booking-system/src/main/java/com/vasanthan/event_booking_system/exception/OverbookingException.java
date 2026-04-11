package com.vasanthan.event_booking_system.exception;


public class OverbookingException extends RuntimeException {
    public OverbookingException(String message) {
        super(message);
    }
}
