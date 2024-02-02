package fr.thibault.cap_entreprise.controller;

import fr.thibault.cap_entreprise.mapping.UrlRoute;
import fr.thibault.cap_entreprise.service.ReviewService;
import fr.thibault.cap_entreprise.service.UserService;
import fr.thibault.cap_entreprise.utils.FlashMessage;
import fr.thibault.cap_entreprise.utils.FlashMessageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping(name = "AppReview")
public class ReviewController {

    private ReviewService reviewService;

    private FlashMessageBuilder flashMessageBuilder;

    private UserService userService;


    @GetMapping(UrlRoute.URL_REVIEW)
    public ModelAndView reviews(
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
        mav.addObject("pageReviews", reviewService.findAll(pageable));
        mav.setViewName("review/index");
        return mav;
    }



    @GetMapping(UrlRoute.URL_REVIEW_MODERATE_PATH)
    public ModelAndView moderate(
            @PathVariable Long id,
            @PathVariable Long moderate,
            ModelAndView modelAndView,
            RedirectAttributes redirectAttributes,
            Principal principal
    ) {
        boolean isModerate = reviewService.moderateReview(principal.getName(), id, moderate);
        FlashMessage flashMessage = flashMessageBuilder.createSuccessFlashMessage("Le commentaire a bien été modéré !");
        if (!isModerate) {
            flashMessage = flashMessageBuilder.createWarningFlashMessage("Le commentaire a bien été supprimé !");
        }
        redirectAttributes.addFlashAttribute("flashMessage", flashMessage);
        modelAndView.setViewName("redirect:/avis");
        return modelAndView;
    }

}
