package fr.thibault.cap_entreprise.configuration;

import fr.thibault.cap_entreprise.mapping.UrlRoute;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/").authenticated()
                                .requestMatchers(UrlRoute.URL_GAME + "/**").authenticated()
                                .requestMatchers(UrlRoute.URL_USER + "/**").authenticated()
                                .requestMatchers(UrlRoute.URL_REVIEW + "/**").hasRole("MODERATOR")
                                .requestMatchers(HttpMethod.POST, UrlRoute.URL_GAME + "/**").hasRole("MODERATOR")
                                .requestMatchers("/**").permitAll()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage(UrlRoute.URL_LOGIN)
                                .defaultSuccessUrl("/", true)
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutSuccessUrl("/login")
                                .permitAll()
                );

        return http.build();
    }

}