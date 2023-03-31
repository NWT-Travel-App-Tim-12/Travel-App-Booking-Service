package com.app.travel.service;

import com.app.travel.models.Itinerary;
import com.app.travel.repository.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService {
    private final ItineraryRepository itineraryRepository;
    @Autowired
    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }
    public List<Itinerary> getAll() {
        return itineraryRepository.findAll();
    }
    public Itinerary createItinerary(Itinerary itinerary) {
        return itineraryRepository.save(itinerary);
    }
    public Integer deleteItinerary(Integer id) {
         itineraryRepository.deleteById(id);
         return 200;
    }
    public Itinerary updateItinerary(Itinerary itinerary) {
        return itineraryRepository.save(itinerary);
    }
}
