package com.app.travel.models;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;
    private Integer bookingId;
    private String userRef;
    private String comment;
    private Float rating;

    public Review(Integer id, Integer bookingId, String userRef, String comment, Float rating) {
        this.id = id;
        this.bookingId = bookingId;
        this.userRef = userRef;
        this.comment = comment;
        this.rating = rating;
    }

    public Review(Integer bookingId, String userRef, String comment, Float rating) {
        this.bookingId = bookingId;
        this.userRef = userRef;
        this.comment = comment;
        this.rating = rating;
    }

    public Review() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserRef() {
        return userRef;
    }

    public void setUserRef(String userRef) {
        this.userRef = userRef;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
