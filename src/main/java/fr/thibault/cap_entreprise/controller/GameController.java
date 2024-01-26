package fr.thibault.cap_entreprise.controller;

import fr.thibault.cap_entreprise.DTO.ReviewDTO;
import fr.thibault.cap_entreprise.entity.Game;
import fr.thibault.cap_entreprise.entity.User;
import fr.thibault.cap_entreprise.mapping.UrlRoute;
import fr.thibault.cap_entreprise.service.GameService;
import fr.thibault.cap_entreprise.service.ReviewService;
import fr.thibault.cap_entreprise.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(name = "AppGame")
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    private final UserService userService;

    @GetMapping(path = UrlRoute.URL_GAME + "/{slug}", name = "show")
    public ModelAndView show(
            @PathVariable String slug,
            ModelAndView mav,
            Principal principal
    ) {
        Game game = gameService.findBySlug(slug);
        // Initialisation du ReviewDTO
        if (principal != null) {
            User user = userService.findByNickname(principal.getName());
            ReviewDTO dto = new ReviewDTO();
            dto.setGameId(game.getId());
            dto.setGamerId(user.getId());
            dto.setModeratorId(user.getId());
            dto.setModeratedAt(dto.getModeratedAt());
            mav.addObject("reviewDto", dto);
        }
        mav.setViewName("game/show");
        mav.addObject("game", game);
        return mav;
    }
}