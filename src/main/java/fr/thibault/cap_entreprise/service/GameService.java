package fr.thibault.cap_entreprise.service;

import fr.thibault.cap_entreprise.entity.Game;
import fr.thibault.cap_entreprise.exception.NotFoundException;
import fr.thibault.cap_entreprise.repository.GameRepository;
import fr.thibault.cap_entreprise.service.interfaces.DAOFindByIdInterface;
import lombok.AllArgsConstructor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService implements DAOFindByIdInterface<Game> {

    private GameRepository gameRepository;

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Game findBySlug(String slug) {
        Optional<Game> optionalGame = gameRepository.findBySlug(slug);
        if (optionalGame.isEmpty()) {
            throw new NotFoundException("Game", "slug", slug);
        }
        return optionalGame.get();
    }


    public List<Game> findTop6ByOrderByPublishedAtDesc() {
        return gameRepository.findTop6ByOrderByPublishedAtDesc();
    }
}