package fr.thibault.cap_entreprise.repository;

import fr.thibault.cap_entreprise.entity.Classification;
import fr.thibault.cap_entreprise.entity.Publisher;
import fr.thibault.cap_entreprise.repository.interfaces.EntityNomenclatureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends
        JpaRepository<Publisher, Long>,
        EntityNomenclatureRepository<Publisher> {

}