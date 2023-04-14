package com.app.travel.controllers;

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
public class BookingController extends  BaseController<Booking, Integer, BookingService>{
    @Autowired
    public BookingController(BookingService bookingService) {
        super(bookingService);
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<Booking>> getAll(int page, int pageSize) throws Exception {
        return super.getAll(page, pageSize);
    }
    @PostMapping
    public ResponseEntity<Booking> post(@RequestBody Booking booking) throws Exception{
        return super.post(booking);
    }
    @PutMapping
    public ResponseEntity<Booking> put(Integer id,@RequestBody Booking booking) throws Exception {
        return  super.put(id, booking);
    }
    @PatchMapping
    public ResponseEntity<Booking> patch(Integer id,@RequestBody Booking booking) throws Exception {
        return  super.put(id, booking);
    }
    @DeleteMapping
    public ResponseEntity<Integer> delete(Integer id) {
        return super.delete(id);
    }
}