package com.app.travel.controller;

import com.app.travel.models.Review;
import com.app.travel.service.ReviewService;
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
@RequestMapping(path="/review")
public class ReviewController {
    private ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping(path="/all")
    public List<Review> getAll() {
        return reviewService.getAll();
    }
    @PostMapping("/new")
    public ResponseEntity<Review> create(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Review> update(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.updateReview(review));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Review> patch(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.updateReview(review));
    }
    @DeleteMapping
    public ResponseEntity<Integer> delete(Integer id) {
        return ResponseEntity.ok(reviewService.deleteReview(id));
    }
}
