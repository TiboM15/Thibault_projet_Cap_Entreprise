package fr.thibault.cap_entreprise.repository;

import fr.thibault.cap_entreprise.entity.BusinessModel;
import fr.thibault.cap_entreprise.repository.interfaces.EntityNomenclatureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessModelRepository extends
        JpaRepository<BusinessModel, Long>,
        EntityNomenclatureRepository<BusinessModel> {

}