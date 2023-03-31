package com.app.travel.service;

import com.app.travel.models.Review;
import com.app.travel.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }
    public Integer deleteReview(Integer id) {
        reviewRepository.deleteById(id);
        return 200;
    }
    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }
}
