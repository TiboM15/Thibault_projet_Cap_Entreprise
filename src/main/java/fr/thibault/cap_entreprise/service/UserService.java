package fr.thibault.cap_entreprise.service;

import fr.thibault.cap_entreprise.DTO.UserPostDTO;
import fr.thibault.cap_entreprise.entity.Gamer;
import fr.thibault.cap_entreprise.entity.Moderator;
import fr.thibault.cap_entreprise.entity.User;
import fr.thibault.cap_entreprise.exception.NotFoundException;
import fr.thibault.cap_entreprise.repository.UserRepository;
import fr.thibault.cap_entreprise.service.interfaces.DAOFindByIdInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements
        DAOFindByIdInterface<User>,
        UserDetailsService
{

    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public User findByNickname(String nickname) {
        return userRepository.findByNickname(nickname)
                .orElseThrow(() -> new NotFoundException("User", "nickname", nickname));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByNickname(username);

        return new org.springframework.security.core.userdetails.User(
                user.getNickname(),
                user.getPassword(),
                userGrantedAuthority(user)
        );
    }

    private List<GrantedAuthority> userGrantedAuthority(User user) {
        if (user instanceof Moderator) {
            return List.of(new SimpleGrantedAuthority("ROLE_MODERATOR"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_GAMER"));
    }

    public Gamer create(UserPostDTO userDTO) {
        Gamer user = new Gamer();
        System.out.println(userDTO.getBirthedAt());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        user.setBirthAt(LocalDate.parse(userDTO.getBirthedAt(), formatter));
        user.setNickname(userDTO.getNickname());
        user.setEmail(userDTO.getEmail().toLowerCase());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return userRepository.saveAndFlush(user);
    }
}
