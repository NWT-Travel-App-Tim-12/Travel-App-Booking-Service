package com.app.travel.models;

import jakarta.persistence.*;
@Entity
@Table(name = "itinerary")
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;
    private Integer bookingId;
    private Integer serviceRef;
    private Integer day;
    private Integer capacity;
    private String regionNote;
    private String name;
    private String description;
    private String serviceType;
    private Object additionalDetails;

    public Itinerary(Integer id, Integer bookingId, Integer serviceRef, Integer day, Integer capacity, String regionNote, String name, String description, String serviceType, Object additionalDetails) {
        this.id = id;
        this.bookingId = bookingId;
        this.serviceRef = serviceRef;
        this.day = day;
        this.capacity = capacity;
        this.regionNote = regionNote;
        this.name = name;
        this.description = description;
        this.serviceType = serviceType;
        this.additionalDetails = additionalDetails;
    }

    public Itinerary(Integer bookingId, Integer serviceRef, Integer day, Integer capacity, String regionNote, String name, String description, String serviceType, Object additionalDetails) {
        this.bookingId = bookingId;
        this.serviceRef = serviceRef;
        this.day = day;
        this.capacity = capacity;
        this.regionNote = regionNote;
        this.name = name;
        this.description = description;
        this.serviceType = serviceType;
        this.additionalDetails = additionalDetails;
    }
    public Itinerary() {
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

    public Integer getServiceRef() {
        return serviceRef;
    }

    public void setServiceRef(Integer serviceRef) {
        this.serviceRef = serviceRef;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getRegionNote() {
        return regionNote;
    }

    public void setRegionNote(String regionNote) {
        this.regionNote = regionNote;
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

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Object getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(Object additionalDetails) {
        this.additionalDetails = additionalDetails;
    }
}
