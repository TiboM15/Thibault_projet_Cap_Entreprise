package fr.thibault.cap_entreprise.repository;

import fr.thibault.cap_entreprise.entity.Genre;
import fr.thibault.cap_entreprise.repository.interfaces.EntityNomenclatureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends
        JpaRepository<Genre, Long>,
        EntityNomenclatureRepository<Genre> {

}