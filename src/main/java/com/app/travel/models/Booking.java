package com.app.travel.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;
    private String bookingCode;
    private String name;
    private String description;
    private String regionNote;
    private Integer userRef;
    private Integer packageRef;
    private Integer numberOfDays;
    private Integer cost;
    private Integer passengerNumber;
    private Boolean paid;
    private LocalDate startAt;
    private LocalDate createdAt;

    public Booking() {
    }

    public Booking(Integer id, String bookingCode, String name, String description, String regionNote, Integer userRef, Integer packageRef, Integer numberOfDays, Integer cost, Integer passengerNumber, Boolean paid, LocalDate startAt, LocalDate createdAt) {
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
    }

    public Booking(String bookingCode, String name, String description, String regionNote, Integer userRef, Integer packageRef, Integer numberOfDays, Integer cost, Integer passengerNumber, Boolean paid, LocalDate startAt, LocalDate createdAt) {
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
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegionNote() {
        return regionNote;
    }

    public void setRegionNote(String regionNote) {
        this.regionNote = regionNote;
    }

    public Integer getUserRef() {
        return userRef;
    }

    public void setUserRef(Integer userRef) {
        this.userRef = userRef;
    }

    public Integer getPackageRef() {
        return packageRef;
    }

    public void setPackageRef(Integer packageRef) {
        this.packageRef = packageRef;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(Integer passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public LocalDate getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDate startAt) {
        this.startAt = startAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
