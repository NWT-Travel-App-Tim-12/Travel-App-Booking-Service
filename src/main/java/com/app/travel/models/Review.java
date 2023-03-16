package com.app.travel.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reviews")
@AllArgsConstructor
@NoArgsConstructor
public class Review {
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
    private String userRef;
    @Getter
    @Setter
    private String comment;
    @Getter
    @Setter
    private Float rating;
}
