package com.app.travel.models;

import com.app.travel.models.additionaldata.AdditionalData;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private Booking bookingRef = null;
    @NotNull
    @Getter
    @Setter
    private Integer serviceRef;
    @Getter
    @Setter
    private Integer day;
    @Max(100)
    @Getter
    @Setter
    private Integer capacity;
    @Getter
    @Setter
    private String regionNote;
    @Size(max=100, message = "Name must contain less than {max} characters.")
    @Getter
    @Setter
    private String name;
   @Size(max=300, message = "Description must contain less than {max} characters.")
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String serviceType;
    @Size(max=300, message = "Additional details must contain less than {max} characters.")
    @Getter
    @Setter
    private String additionalDetails;
    @Getter
    @Setter
    private String imageUrl;

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
