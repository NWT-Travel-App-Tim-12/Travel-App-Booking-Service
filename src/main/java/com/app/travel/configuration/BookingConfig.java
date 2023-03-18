package com.app.travel.configuration;

import com.app.travel.models.Booking;
import com.app.travel.repository.BookingRepository;
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
            Booking b1 = new Booking("R8092", "Booking Num1", "First booking this year","Region 1", 1,1,10,2393,30, true, LocalDate.now(), LocalDate.of(2023,1,1), null,null);
            Booking b2 = new Booking("FH73H", "Booking Num2", "Best booking this year","South region", 4,2,15,400,20, false, LocalDate.now(), LocalDate.of(2023,2,1), null,null);
            Booking b3 = new Booking("HD73H", "Booking Num3", "Have fun","East region", 10,10,21,600,13, true, LocalDate.now(), LocalDate.of(2023,1,1), null,null);
            bookingRepository.saveAll(List.of(b1, b2, b3));
        };
    }
}
