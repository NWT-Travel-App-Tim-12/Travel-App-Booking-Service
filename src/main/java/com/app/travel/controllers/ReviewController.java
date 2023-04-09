package com.app.travel.controllers;

import com.app.travel.models.Itinerary;
import com.app.travel.models.Review;
import com.app.travel.service.BaseCrudService;
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
public class ReviewController extends BaseController<Review,Integer, ReviewService> {
    private ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        super(reviewService);
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<Review>> getAll(int page, int pageSize) throws Exception {
        return super.getAll(page, pageSize);
    }
    @PostMapping
    public ResponseEntity<Review> post(@RequestBody Review review) throws Exception{
        return super.post(review);
    }
    @PutMapping
    public ResponseEntity<Review> put(Integer id,@RequestBody Review review) throws Exception {
        return  super.put(id, review);
    }
    @PatchMapping
    public ResponseEntity<Review> patch(Integer id,@RequestBody Review review) throws Exception {
        return  super.put(id, review);
    }
    @DeleteMapping
    public ResponseEntity<Integer> delete(Integer id) {
        return super.delete(id);
    }
}
