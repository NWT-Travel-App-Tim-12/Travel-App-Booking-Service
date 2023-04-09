package com.app.travel.configuration;

import com.app.travel.models.Booking;
import com.app.travel.models.Review;
import com.app.travel.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ReviewConfig {
    @Bean
    CommandLineRunner commandLineRunnerReview (ReviewRepository reviewRepository){
        Booking booking = new Booking(1,"R8092", "Booking Num1", "First booking this year","Region 1", 1,1,10,2393,30, true, LocalDate.now(), LocalDate.of(2023,1,1), null,null);
        Review r1 = new Review(booking, "2","Not so good", 0.56F);
        Review r2 = new Review(booking, "4","Great", 1F);
        Review r3 = new Review(booking, "22","Awesome", 1F);
        Review r4 = new Review(booking, "29","I'm not satisfied", 0.3F);
        return args -> {
            reviewRepository.saveAll(List.of(r1,r2,r3,r4));
        };
    }
}
