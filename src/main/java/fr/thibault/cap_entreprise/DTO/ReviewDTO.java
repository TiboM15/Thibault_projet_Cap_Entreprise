package fr.thibault.cap_entreprise.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewDTO {

    @NotNull
    @DecimalMin(
            value = "0",
            message= "The rating should be at least 0"
    )
    @DecimalMax(
            value = "5",
            message= "The rating should be 5 at max"
    )
    private Float rating;

    @NotBlank
    private String description;

    private LocalDateTime moderatedAt;

    @Positive(message = "The moderator id has to be positive")
    private Long moderatorId;

    @NotNull(message = "The gamer is required")
    @Positive(message = "The gamer id has to be positive")
    private Long gamerId;

    @NotNull(message = "The game is required")
    @Positive(message = "The game id has to be positive")
    private Long gameId;

}