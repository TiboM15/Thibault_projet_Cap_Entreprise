package fr.thibault.cap_entreprise.service;

import fr.thibault.cap_entreprise.entity.Genre;
import fr.thibault.cap_entreprise.repository.GenreRepository;
import fr.thibault.cap_entreprise.service.interfaces.DAOEntityInterface;
import lombok.AllArgsConstructor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService implements DAOEntityInterface<Genre> {

    private GenreRepository genreRepository;

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}