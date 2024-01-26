package fr.thibault.cap_entreprise.service;

import fr.thibault.cap_entreprise.entity.Review;
import fr.thibault.cap_entreprise.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    private ReviewRepository reviewRepository;

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    public List<Review> findTop9ByOrderByCreatedAtDesc() {
        return reviewRepository.findTop9ByOrderByCreatedAtDesc();
    }

}