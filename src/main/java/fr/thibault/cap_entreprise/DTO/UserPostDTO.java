package fr.thibault.cap_entreprise.DTO;

import fr.thibault.cap_entreprise.validator.annotation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserPostDTO {

    @Email(message = "Please, give a valid email")
    @NotBlank(message = "Please, give an email")
    // On peut réécrire les valeurs des champs de l'annotation
    @UniqueEmail(example = "toto@gmail.com")
    private String email;

    @NotBlank(message = "Please, give a proper nickname")
    @Size(message = "The account name must have at least 5 characters", min = 5)
    private String nickname;

    @NotBlank(message = "Please, the password must have a value")
    @Size(message = "The password must have at least 8 characters", min = 8)
    private String password;

    @NotBlank(message = "Please, enter a valid Date (dd/MM/yyyy")
    private String birthedAt;
}