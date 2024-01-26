package fr.thibault.cap_entreprise.repository;

import fr.thibault.cap_entreprise.entity.Classification;
import fr.thibault.cap_entreprise.entity.Review;
import fr.thibault.cap_entreprise.repository.interfaces.EntityNomenclatureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends
        JpaRepository<Review, Long>
{

    List<Review> findTop9ByOrderByCreatedAtDesc();

}