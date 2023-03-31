package com.app.travel.controller;

import com.app.travel.models.Booking;
import com.app.travel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<Booking> getAll() {
        return bookingService.getBookings();
    }

    @PostMapping("/new")
    public ResponseEntity<Booking> create(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Booking> update(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.updateBooking(booking));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Booking> patch(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.updateBooking(booking));
    }
    @DeleteMapping
    public ResponseEntity<Integer> delete(Integer id) {
        return ResponseEntity.ok(bookingService.deleteBooking(id));
    }

}
