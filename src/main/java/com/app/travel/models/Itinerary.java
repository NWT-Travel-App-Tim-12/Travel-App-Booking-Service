package com.app.travel.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "itineraries")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @Getter
    @Setter
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonBackReference
    @Getter
    @Setter
    private Booking bookingRef;
    @Getter
    @Setter
    private Integer serviceRef;
    @Getter
    @Setter
    private Integer day;
    @Getter
    @Setter
    private Integer capacity;
    @Getter
    @Setter
    private String regionNote;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String serviceType;
    @Getter
    @Setter
    private String additionalDetails;

    public Itinerary(Booking bookingRef, Integer serviceRef, Integer day, Integer capacity, String regionNote, String name, String description, String serviceType, String additionalDetails) {
        this.bookingRef = bookingRef;
        this.serviceRef = serviceRef;
        this.day = day;
        this.capacity = capacity;
        this.regionNote = regionNote;
        this.name = name;
        this.description = description;
        this.serviceType = serviceType;
        this.additionalDetails = additionalDetails;
    }
}
