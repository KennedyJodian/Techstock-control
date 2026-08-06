package com.techsctock.techstockcontrol.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.techsctock.techstockcontrol.service.CustomUserDetailsService;


@Configuration
public class SecurityConfig {


    private final CustomUserDetailsService customUserDetailsService;


    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {

        this.customUserDetailsService = customUserDetailsService;

    }


    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http

            .userDetailsService(customUserDetailsService)


            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**")
            )


            .headers(headers -> headers
                .frameOptions(frame -> frame.sameOrigin())
            )


            .authorizeHttpRequests(auth -> auth


                .requestMatchers(
                    "/",
                    "/about",
                    "/contact",
                    "/login",
                    "/register",
                    "/css/**",
                    "/images/**",
                    "/h2-console/**"
                ).permitAll()


                .requestMatchers("/admin/**")
                .hasRole("ADMIN")


                .anyRequest()
                .authenticated()
            )


            .formLogin(login -> login

                .loginPage("/login")
                .loginProcessingUrl("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/", true)
                .permitAll()
            )


            .logout(logout -> logout

                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            )

            .exceptionHandling(exception -> exception
                .accessDeniedPage("/403")
            );


        return http.build();

    }



    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

}
    