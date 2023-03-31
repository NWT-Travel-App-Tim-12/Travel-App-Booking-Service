package com.app.travel.controller;

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
public class ItineraryController {
    private ItineraryService itineraryService;
    @Autowired
    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }
    @GetMapping(path="/all")
    public List<Itinerary> getAll() {
        return itineraryService.getAll();
    }
    @PostMapping("/new")
    public ResponseEntity<Itinerary> create(@RequestBody Itinerary itinerary) {
        return ResponseEntity.ok(itineraryService.createItinerary(itinerary));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Itinerary> update(@RequestBody Itinerary itinerary) {
        return ResponseEntity.ok(itineraryService.updateItinerary(itinerary));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Itinerary> patch(@RequestBody Itinerary itinerary) {
        return ResponseEntity.ok(itineraryService.updateItinerary(itinerary));
    }
    @DeleteMapping
    public ResponseEntity<Integer> delete(Integer id) {
        return ResponseEntity.ok(itineraryService.deleteItinerary(id));
    }

}
