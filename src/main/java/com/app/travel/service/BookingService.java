package com.app.travel.service;

import com.app.travel.models.Booking;
import com.app.travel.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
}
