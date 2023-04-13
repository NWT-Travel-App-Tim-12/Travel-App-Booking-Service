package com.app.travel.configuration;

import com.app.travel.models.Booking;
import com.app.travel.models.Itinerary;
import com.app.travel.repositories.ItineraryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ItineraryConfig {
    @Bean
    CommandLineRunner commandLineRunnerItinerary (ItineraryRepository itineraryRepository){
        Itinerary ii = new Itinerary(new Booking(1,"R8092", "Booking Num1", "First booking this year","Region 1", 1,1,10,2393,30, true, LocalDate.now(), LocalDate.of(2023,1,1), null,null)
                , 1,4,34,"FJ463", "itinerary 1", "Short description", "Hotel", "Some details");
        return args -> {
//            itineraryRepository.saveAll(List.of(ii));
        };
    }
}
