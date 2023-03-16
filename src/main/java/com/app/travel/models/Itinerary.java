package com.app.travel.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "itineraries")
@AllArgsConstructor
@NoArgsConstructor
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @Getter
    @Setter
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
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
}
