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
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "BNS_ROLE")
@EntityListeners(AuditingEntityListener.class)
public class BsnRole {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(unique = true)
	private String name;

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Column(insertable = false)
	private LocalDateTime lastModifiedDate;

	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private List<BsnUser> user;

	public String getName() {
		return name;
	}
}
