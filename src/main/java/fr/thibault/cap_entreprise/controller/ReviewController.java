package fr.thibault.cap_entreprise.controller;

import fr.thibault.cap_entreprise.DTO.ReviewDTO;
import fr.thibault.cap_entreprise.mapping.UrlRoute;
import fr.thibault.cap_entreprise.service.GameService;
import fr.thibault.cap_entreprise.service.ReviewService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping(name = "AppReview")
public class ReviewController {

    private ReviewService reviewService;

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
        mav.setViewName("review/show");
        return mav;
    }
}
