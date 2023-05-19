package ru.astondevs.motorent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.astondevs.motorent.security.jwt.JwtTokenFilter;
import ru.astondevs.motorent.security.jwt.JwtTokenProvider;

import static ru.astondevs.motorent.domain.entity.users.Role.ADMINISTRATOR;

@Configuration
@ComponentScan("ru.astondevs")
public class SecurityConf {
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationConfiguration configuration;

    public SecurityConf(JwtTokenProvider jwtTokenProvider, AuthenticationConfiguration configuration) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.configuration = configuration;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/login", "/api/v1/register")
                .permitAll()
                .requestMatchers("/api/v1/admin/**")
                .hasAuthority(ADMINISTRATOR.name())
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
