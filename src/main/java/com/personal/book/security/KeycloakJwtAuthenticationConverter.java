package com.personal.book.security;

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

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
	@Override
	public AbstractAuthenticationToken convert(@NonNull Jwt source) {
		return new JwtAuthenticationToken(source,
				Stream.concat(new JwtGrantedAuthoritiesConverter().convert(source).stream(),
						extractResourceRoles(source).stream()).collect(toSet()));
	}

	private Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt) {
		var resourceAccess = new HashMap<>(jwt.getClaim("resource_access"));

		var eternal = (Map<String, List<String>>) resourceAccess.get("account");

		var roles = eternal.get("roles");

		return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.replace("-", "_")))
				.collect(toSet());
	}
}
