package com.app.travel.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String bookingCode;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String regionNote;
    @Getter
    @Setter
    private Integer userRef;
    @Getter
    @Setter
    private Integer packageRef;
    @Getter
    @Setter
    private Integer numberOfDays;
    @Getter
    @Setter
    private Integer cost;
    @Getter
    @Setter
    private Integer passengerNumber;
    @Getter
    @Setter
    private Boolean paid;
    @Getter
    @Setter
    private LocalDate startAt;
    @Getter
    @Setter
    private LocalDate createdAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id")
    @Getter
    @Setter
    private List<Itinerary> itineraries;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id")
    @Getter
    @Setter
    private List<Review> reviews;

    public Booking(String bookingCode, String name, String description, String regionNote, Integer userRef, Integer packageRef, Integer numberOfDays, Integer cost, Integer passengerNumber, Boolean paid, LocalDate startAt, LocalDate createdAt, List<Itinerary> itineraries, List<Review> reviews) {
        this.id = id;
        this.bookingCode = bookingCode;
        this.name = name;
        this.description = description;
        this.regionNote = regionNote;
        this.userRef = userRef;
        this.packageRef = packageRef;
        this.numberOfDays = numberOfDays;
        this.cost = cost;
        this.passengerNumber = passengerNumber;
        this.paid = paid;
        this.startAt = startAt;
        this.createdAt = createdAt;
        this.itineraries = itineraries;
        this.reviews = reviews;
    }

}
