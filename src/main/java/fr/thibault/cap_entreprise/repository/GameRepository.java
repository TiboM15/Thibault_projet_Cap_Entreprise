package fr.thibault.cap_entreprise.repository;

import fr.thibault.cap_entreprise.entity.Classification;
import fr.thibault.cap_entreprise.entity.Game;
import fr.thibault.cap_entreprise.repository.interfaces.EntityNomenclatureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends
        JpaRepository<Game, Long>,
        EntityNomenclatureRepository<Game>
{

    Optional<Game> findBySlug(String slug);

    List<Game> findTop6ByOrderByPublishedAtDesc();

}