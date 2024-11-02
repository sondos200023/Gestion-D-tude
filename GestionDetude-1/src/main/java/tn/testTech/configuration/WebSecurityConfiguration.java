package tn.testTech.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import tn.testTech.filters.JwtRequestFilter;

//securité

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration {
	private final JwtRequestFilter jwtRequestFilter;

    @Autowired
    public WebSecurityConfiguration(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security .cors()  //Active le CORS pour permettre les requêtes d’autres domaines
                .and()
        		.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/signup", "/login").permitAll() // accées public au endpoints signup et login
               .anyRequest().authenticated()  
                .and()
                // .authorizeHttpRequests().requestMatchers("/api/**")
                //.authenticated()
               // .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //chaque requete est authentifier independament avec tokens JWT
                .and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)//Ajoute le jwtRequestFilter avant le filtre de gestion d’authentification UsernamePasswordAuthenticationFilter. Ce filtre traite le jeton JWT de chaque requête pour valider l’identité de l’utilisateur.
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


}
