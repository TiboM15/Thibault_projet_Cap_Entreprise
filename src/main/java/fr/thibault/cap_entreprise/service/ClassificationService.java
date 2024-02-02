package fr.thibault.cap_entreprise.service;

import fr.thibault.cap_entreprise.entity.Classification;
import fr.thibault.cap_entreprise.repository.ClassificationRepository;
import fr.thibault.cap_entreprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassificationService implements
        DAOEntityInterface<Classification>
{

    private ClassificationRepository classificationRepository;

    @Override
    public List<Classification> findAll() {
        return classificationRepository.findAll();
    }


    @Override
    public Classification findById(Long id) {
        return classificationRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Classification> findAllSorted() {
        return classificationRepository.findAllByOrderByNameAsc();
    }
}