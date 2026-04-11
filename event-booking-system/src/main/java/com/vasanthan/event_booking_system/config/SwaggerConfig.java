package com.vasanthan.event_booking_system.config;


import org.springframework.context.annotation.*;
import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springdoc.core.models.GroupedOpenApi;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI eventBookingOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Event Booking System API")
                        .version("1.0")
                        .description("API for managing events and bookings"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("public").pathsToMatch("/**").build();
    }
}
