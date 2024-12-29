/*
 * This code is part of the book-social-network project.
 * Use of this code anywhere without the project owner's (https://github.com/Pratik-Zimbre) permission is prohibited.
 */
package com.personal.book.entity;

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
