package com.personal.book.config;

/*-
 * #%L
 * book-network-api
 * %%
 * Copyright (C) 2024 Book Social Network
 * %%
 * Book Social Network, Inc. and / or its subsidiaries - All Rights Reserved worldwide. 
 * This document is protected under the trade secret and copyright laws as the property of Book Social Network, Inc. and / or its subsidiaries.
 * Copying, reproduction or distribution should be limited and only to contributors with a "need to know" to do their job.
 * Any disclosure of this document to third parties is strictly prohibited.
 * #L%
 */

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BeansConfig {

	// private final UserDetailsService userDetailsService;

	/*
	 * @Bean public AuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	 * authProvider.setUserDetailsService(userDetailsService);
	 * authProvider.setPasswordEncoder(passwordEncoder()); return authProvider; }
	 * 
	 * @Bean public AuthenticationManager
	 * authenticationManager(AuthenticationConfiguration config) throws Exception {
	 * return config.getAuthenticationManager(); }
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */

	@Bean
	AuditorAware<String> auditorAware() {
		return new ApplicationAuditAware();
	}

	@Bean
	CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		config.setAllowedHeaders(Arrays.asList(HttpHeaders.ORIGIN, HttpHeaders.CONTENT_TYPE, HttpHeaders.ACCEPT,
				HttpHeaders.AUTHORIZATION));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT", "PATCH"));
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);

	}

}
