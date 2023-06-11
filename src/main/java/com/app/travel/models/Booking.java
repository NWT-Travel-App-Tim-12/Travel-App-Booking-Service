package com.app.travel.models;

import com.app.travel.models.dto.CreatedBooking;
import com.app.travel.util.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @Size(min=3, max = 100, message = "Name must be between {min} and {max} characters!")
    @Getter
    @Setter
    private String name;
    @Size( max = 100, message = "Name must be between {min} and {max} characters!")
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String regionNote;
    @Getter
    @Setter
    private Integer userRef = -1;
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

    @Getter
    @Setter
    private BookingStatus status;

    @Getter
    @Setter
    private String imageUrl;
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


    public void assignFromCreatedBooking(CreatedBooking createdBooking){
        this.bookingCode = createdBooking.getBookingCode();
        this.name = createdBooking.getName();
        this.description = createdBooking.getDescription();
        this.regionNote = createdBooking.getRegionNote();
        this.userRef = createdBooking.getUserRef();
        this.packageRef = createdBooking.getPackageRef();
        this.numberOfDays = createdBooking.getNumberOfDays();
        this.cost = createdBooking.getCost();
        this.passengerNumber = createdBooking.getPassengerNumber();
        this.paid = createdBooking.getPaid();
        this.startAt = createdBooking.getStartAt();
        this.createdAt = createdBooking.getCreatedAt();
        this.itineraries = createdBooking.getItineraries().stream().map(el -> el.toItinerary(this)).toList();
        this.reviews = List.of(new Review(
                this,
                "-1",
                "",
                0f
        ));
        this.imageUrl = createdBooking.getImageUrl() == null ? "" : createdBooking.getImageUrl();
        this.status = createdBooking.getStatus();
    }

}
