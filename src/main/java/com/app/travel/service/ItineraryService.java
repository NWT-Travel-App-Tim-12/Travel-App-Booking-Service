package com.app.travel.service;

import com.app.travel.models.Itinerary;
import com.app.travel.repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService extends BaseCrudService<Itinerary, Integer> {
    @Autowired
    public ItineraryService(ItineraryRepository itineraryRepository) {
        super(itineraryRepository);
    }

}
