package com.app.travel.models.dto;

import com.app.travel.util.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedBooking {
    private Integer id;
    private String bookingCode;
    private String name;
    private String description;
    private String regionNote;
    private Integer userRef;
    private Integer packageRef;
    private Integer numberOfDays;
    private Integer cost;
    private Integer passengerNumber;
    private Boolean paid;
    private LocalDate startAt;
    private LocalDate createdAt;

    private List<CreatedItineraries> itineraries;

    private BookingStatus status;
    private String imageUrl;

}
