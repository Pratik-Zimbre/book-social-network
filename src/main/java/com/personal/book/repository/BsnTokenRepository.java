package com.personal.book.repository;

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

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.book.entity.BsnToken;

public interface BsnTokenRepository extends JpaRepository<BsnToken, Integer> {

	Optional<BsnToken> findByToken(String token);
}
