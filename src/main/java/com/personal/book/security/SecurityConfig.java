/*
 * This code is part of the book-social-network project.
 * Use of this code anywhere without the project owner's (https://github.com/Pratik-Zimbre) permission is prohibited.
 */
package com.personal.book.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

	private final AuthenticationProvider authenticationProvider;
	private final JwtFilter jwtAuthFilter;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.cors(Customizer.withDefaults()).csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(req -> req
						.requestMatchers("/auth/**", "/v2/api-docs", "/v3/api-docs", "/v3/api-docs/**",
								"/swagger-resources", "/swagger-resources/**", "/configuration/ui",
								"/configuration/security", "/swagger-ui/**", "/webjars/**", "/swagger-ui.html")
						.permitAll().anyRequest().authenticated())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider)
				.addFilterBefore((Filter) jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}
