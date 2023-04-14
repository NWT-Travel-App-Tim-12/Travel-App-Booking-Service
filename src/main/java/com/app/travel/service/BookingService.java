package com.app.travel.service;

import com.app.travel.models.Booking;
import com.app.travel.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingService extends  BaseCrudService<Booking, Integer> {
    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        super(bookingRepository);
    }
}
