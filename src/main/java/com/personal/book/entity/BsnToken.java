package com.personal.book.entity;

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

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BNS_TOKEN")
public class BsnToken {

	@Id
	@GeneratedValue
	private Integer id;

	private String token;

	private LocalDateTime createdAt;

	private LocalDateTime expiresAt;

	private LocalDateTime validatedAt;

	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private BsnUser user;
}
