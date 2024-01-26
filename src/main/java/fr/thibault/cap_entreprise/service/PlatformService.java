package fr.thibault.cap_entreprise.service;

import fr.thibault.cap_entreprise.entity.Platform;
import fr.thibault.cap_entreprise.repository.PlatformRepository;
import fr.thibault.cap_entreprise.service.interfaces.DAOEntityInterface;
import lombok.AllArgsConstructor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlatformService implements
        DAOEntityInterface<Platform>
{

    private PlatformRepository platformRepository;

    @Override
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

    @Override
    public Platform findById(Long id) {
        return platformRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}