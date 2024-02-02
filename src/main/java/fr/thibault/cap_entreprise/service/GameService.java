package fr.thibault.cap_entreprise.service;

import fr.thibault.cap_entreprise.DTO.GameDTO;
import fr.thibault.cap_entreprise.entity.Game;
import fr.thibault.cap_entreprise.entity.Moderator;
import fr.thibault.cap_entreprise.exception.NotFoundException;
import fr.thibault.cap_entreprise.repository.GameRepository;
import fr.thibault.cap_entreprise.service.interfaces.DAOFindByIdInterface;
import lombok.AllArgsConstructor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService implements DAOFindByIdInterface<Game> {

    private GameRepository gameRepository;

    private UserService userService;

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Page<Game> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
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

    public Game create(GameDTO gameDTO, String nickname) {
        Game game = new Game();
        game.setName(gameDTO.getName());
        game.setDescription(gameDTO.getDescription());
        game.setPublishedAt(LocalDate.parse(gameDTO.getPublishedAt()));
        game.setGenre(gameDTO.getGenre());
        game.setBusinessModel(gameDTO.getBusinessModel());
        game.setPublisher(gameDTO.getPublisher());
        game.setClassification(gameDTO.getClassification());
        game.setPlatforms(gameDTO.getPlatforms());
        game.setModerator((Moderator) userService.findByNickname(nickname));
        game.setImage("https://static.vecteezy.com/system/resources/previews/005/337/799/original/icon-image-not-found-free-vector.jpg");
        return gameRepository.saveAndFlush(game);
    }

    public void saveImageToGame(String fileName, String slug) {
        Game game = findBySlug(slug);
        game.setImage(fileName);
        gameRepository.flush();
    }
}