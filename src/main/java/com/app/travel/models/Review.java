package com.app.travel.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
    @NotNull
    @Valid
    @Getter
    @Setter
    private Booking bookingRef;
    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String userRef;
    @Getter
    @Setter
    @Size(max = 50, message = "Comment must contain less than {max} characters.")
    private String comment;
    @Getter
    @Setter
    @DecimalMin(value="0.0")
    @DecimalMax(value="1.0")
    private Float rating;

    public Review(Booking bookingRef, String userRef, String comment, Float rating) {
        this.bookingRef = bookingRef;
        this.userRef = userRef;
        this.comment = comment;
        this.rating = rating;
    }
}
