/*
 * This code is part of the book-social-network project.
 * Use of this code anywhere without the project owner's (https://github.com/Pratik-Zimbre) permission is prohibited.
 */
package com.personal.book.entity;

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
