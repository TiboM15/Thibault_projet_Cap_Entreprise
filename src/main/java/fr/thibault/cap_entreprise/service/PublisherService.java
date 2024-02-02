package fr.thibault.cap_entreprise.service;

import fr.thibault.cap_entreprise.entity.Publisher;
import fr.thibault.cap_entreprise.repository.PublisherRepository;
import fr.thibault.cap_entreprise.service.interfaces.DAOEntityInterface;
import lombok.AllArgsConstructor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherService implements
        DAOEntityInterface<Publisher>
{

    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Publisher> findAllSorted() {
        return publisherRepository.findAllByOrderByNameAsc();
    }
}