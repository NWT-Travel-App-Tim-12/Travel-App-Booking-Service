package com.app.travel.configuration;

import com.app.travel.models.Booking;
import com.app.travel.repositories.BookingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BookingConfig {
    @Bean
    CommandLineRunner commandLineRunnerBooking (BookingRepository bookingRepository){
        return args -> {
            Booking b1 = new Booking(1,"R8092", "Booking Num1", "First booking this year","Region 1", 1,1,10,2393,30, true, LocalDate.now(), LocalDate.of(2023,1,1), null,null);
            bookingRepository.saveAll(List.of(b1));

        };
    }
}
