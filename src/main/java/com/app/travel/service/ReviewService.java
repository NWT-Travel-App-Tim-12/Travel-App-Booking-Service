package com.app.travel.service;

import com.app.travel.models.Review;
import com.app.travel.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends BaseCrudService<Review, Integer>{
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        super(reviewRepository);
    }
}
