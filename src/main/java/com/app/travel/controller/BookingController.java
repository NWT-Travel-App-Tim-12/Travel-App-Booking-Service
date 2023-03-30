package com.app.travel.controller;

import com.app.travel.models.Booking;
import com.app.travel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path="/booking")
public class BookingController {
    private BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping(path="/all")
    public List<Booking> getBookings() {
        return bookingService.getBookings();
    }

}
