package fr.thibault.cap_entreprise.controller;

import fr.thibault.cap_entreprise.DTO.UserPostDTO;
import fr.thibault.cap_entreprise.mapping.UrlRoute;
import fr.thibault.cap_entreprise.service.GameService;
import fr.thibault.cap_entreprise.service.ReviewService;
import fr.thibault.cap_entreprise.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



import java.security.Principal;

@Controller
@AllArgsConstructor
public class HomeController {

    private UserService userService;

    private GameService gameService;

    private ReviewService reviewService;

    @GetMapping("/")
    public ModelAndView index(
            ModelAndView mav,
            Principal principal,
            @PageableDefault(
                    size = 6, // nb Element par page
                    sort = { "createdAt" }, // order by
                    direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        if (principal == null) {
            mav.setViewName("redirect:/login");
            return mav;
        }
        mav.setViewName("index");
        mav.addObject("gamesReleased", gameService.findTop6ByOrderByPublishedAtDesc());
        return mav;
    }

    @GetMapping(value = UrlRoute.URL_LOGIN)
    public ModelAndView login(ModelAndView mav, String error) {
        if (error != null) {
            mav.addObject("error", "Your username or password is invalid.");
        }
        mav.setViewName("security/login");
        return mav;
    }

    @GetMapping(UrlRoute.URL_REGISTER)
    public ModelAndView register(ModelAndView mav) {
        mav.setViewName("security/register");
        mav.addObject("userForm", new UserPostDTO());
        return mav;
    }

    @PostMapping(UrlRoute.URL_REGISTER)
    public ModelAndView register(
            @Valid @ModelAttribute("userForm") UserPostDTO userForm,
            BindingResult bindingResult,
            ModelAndView mav
    ) {
        if (bindingResult.hasErrors()) {
            mav.setViewName("security/register");
            return mav;
        }
        userService.create(userForm);
        mav.setViewName("redirect:" + UrlRoute.URL_LOGIN);
        return mav;

    }

}

