package com.app.travel.controllers;

import com.app.travel.models.Booking;
import com.app.travel.models.dto.BookingCreationDto;
import com.app.travel.models.dto.BookingProducerDto;
import com.app.travel.models.dto.CreatedBooking;
import com.app.travel.service.BookingService;
import com.app.travel.service.RabbitMQProducer;
import com.app.travel.util.BookingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping(path="/booking")
public class BookingController extends  BaseController<Booking, Integer, BookingService>{
    @Autowired
    public BookingController(BookingService bookingService) {
        super(bookingService);
    }

    @Autowired
    public RabbitMQProducer producer;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Booking> get(@PathVariable Integer bookingId) throws Exception {
        return super.get(bookingId);
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<Booking>> getAll(int page, int pageSize) throws Exception {
        return super.getAll(page, pageSize);
    }
    /*
    @PostMapping
    public ResponseEntity<Booking> post(@RequestBody Booking booking) throws Exception{
        return super.post(booking);
    }
    */
    @PostMapping
    public ResponseEntity<HashMap<String, Object>> post(@RequestBody BookingCreationDto booking) throws Exception{
        var newBooking = service.insert(new Booking());
        producer.sendMessage(new BookingProducerDto(newBooking.getId(), booking).toString());
        var result = new HashMap<String, Object>();
        result.put("bookingId", newBooking.getId());
        result.put("requestStatus", BookingStatus.UnderReview);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(result);
    }
    @PutMapping
    public ResponseEntity<Booking> put(Integer id,@RequestBody Booking booking) throws Exception {
        return super.put(id, booking);
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Booking> putMessage(@PathVariable Integer id, @RequestBody CreatedBooking booking) throws Exception {
        var res = service.get(id);
        res.assignFromCreatedBooking(booking);
        //res.setItineraries(null);
        service.delete(id);
        service.insert(res);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
    @PatchMapping
    public ResponseEntity<Booking> patch(Integer id, @RequestBody Booking booking) throws Exception {
        return super.put(id, booking);
    }
    @DeleteMapping
    public ResponseEntity<Integer> delete(Integer id) {
        return super.delete(id);
    }
}
