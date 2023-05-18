package ru.astondevs.motorent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.astondevs.motorent.security.jwt.JwtConfigurer;
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
//        AbstractAuthenticationProcessingFilter filter = new CustomizedAuthenticationFilter(authenticationManager());
//        filter.setFilterProcessesUrl("/api/login");
//        http.csrf().disable();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeHttpRequests();
//        http.authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/api/login").permitAll();
//        http.authorizeHttpRequests().requestMatchers("/api/admin/**").hasAnyRole(ADMINISTRATOR.name());
//        http.authorizeHttpRequests().anyRequest().authenticated();
//        http.apply(new JwtConfigurer(jwtTokenProvider));
////        http.addFilter(filter);
//
//        return http.build();
//    }
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/api/login", "/api/register"
                )
                .permitAll()
                .requestMatchers("/api/admin/**")
                .hasAuthority(ADMINISTRATOR.name())


                /* .requestMatchers("/api/v1/admin/**").hasRole(ADMIN.name())

                 .requestMatchers(GET, "/api/v1/admin/**").hasAuthority(ADMIN_READ.name())
                 .requestMatchers(POST, "/api/v1/admin/**").hasAuthority(ADMIN_CREATE.name())
                 .requestMatchers(PUT, "/api/v1/admin/**").hasAuthority(ADMIN_UPDATE.name())
                 .requestMatchers(DELETE, "/api/v1/admin/**").hasAuthority(ADMIN_DELETE.name())*/


                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
//                .authenticationProvider(jwtTokenProvider)
                .addFilterBefore(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
//                .logout()
//                .logoutUrl("/api/v1/auth/logout")
//                .addLogoutHandler(logoutHandler)
//                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
        ;

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
