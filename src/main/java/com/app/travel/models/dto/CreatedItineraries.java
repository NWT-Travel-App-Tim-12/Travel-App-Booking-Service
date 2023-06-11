package com.app.travel.models.dto;

import com.app.travel.models.Booking;
import com.app.travel.models.Itinerary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedItineraries {
    private Integer id;

    private Integer serviceRef;

    private Integer day;

    private Integer capacity;

    private String regionNote;

    private String name;

    private String description;

    private String serviceType;

    private String additionalDetails;
    private String imageUrl;

    public Itinerary toItinerary(Booking ref) {
        return new Itinerary(
        id, ref,
        serviceRef,
        day,
        capacity,
        regionNote,
        name,
        description,
        serviceType,
        additionalDetails,
                imageUrl == null ? "": imageUrl
        );
    }
}
