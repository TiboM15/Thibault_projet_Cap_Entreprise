package fr.thibault.cap_entreprise.service;

import fr.thibault.cap_entreprise.entity.BusinessModel;
import fr.thibault.cap_entreprise.repository.BusinessModelRepository;
import fr.thibault.cap_entreprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BusinessModelService implements
        DAOEntityInterface<BusinessModel>
{

    private BusinessModelRepository businessModelRepository;

    @Override
    public List<BusinessModel> findAll() {
        return businessModelRepository.findAll();
    }

    @Override
    public BusinessModel findById(Long id) {
        return businessModelRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

}