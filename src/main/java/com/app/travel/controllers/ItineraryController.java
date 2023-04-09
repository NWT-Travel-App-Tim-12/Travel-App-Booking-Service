package com.app.travel.controllers;

import com.app.travel.models.Booking;
import com.app.travel.models.Itinerary;
import com.app.travel.service.ItineraryService;
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
@RequestMapping(path="/itinerary")
public class ItineraryController extends BaseController<Itinerary, Integer, ItineraryService> {
    @Autowired
    public ItineraryController(ItineraryService itineraryService) {
       super(itineraryService);
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<Itinerary>> getAll(int page, int pageSize) throws Exception {
        return super.getAll(page, pageSize);
    }
    @PostMapping
    public ResponseEntity<Itinerary> post(@RequestBody Itinerary itinerary) throws Exception{
        return super.post(itinerary);
    }
    @PutMapping
    public ResponseEntity<Itinerary> put(Integer id,@RequestBody Itinerary itinerary) throws Exception {
        return  super.put(id, itinerary);
    }
    @PatchMapping
    public ResponseEntity<Itinerary> patch(Integer id,@RequestBody Itinerary itinerary) throws Exception {
        return  super.put(id, itinerary);
    }
    @DeleteMapping
    public ResponseEntity<Integer> delete(Integer id) {
        return super.delete(id);
    }

}
