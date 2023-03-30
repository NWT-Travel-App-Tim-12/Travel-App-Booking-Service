package com.app.travel.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reviews")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Review {
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
    private String userRef;
    @Getter
    @Setter
    private String comment;
    @Getter
    @Setter
    private Float rating;

    public Review(Booking bookingRef, String userRef, String comment, Float rating) {
        this.bookingRef = bookingRef;
        this.userRef = userRef;
        this.comment = comment;
        this.rating = rating;
    }
}
