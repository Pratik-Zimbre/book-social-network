package com.personal.book.repository;

/*-
 * #%L
 * book-network-api
 * %%
 * Copyright (C) 2024 - 2025 Book Social Network
 * %%
 * Book Social Network, Inc. and / or its subsidiaries - All Rights Reserved worldwide. 
 * This document is protected under the trade secret and copyright laws as the property of Book Social Network, Inc. and / or its subsidiaries.
 * Copying, reproduction or distribution should be limited and only to contributors with a "need to know" to do their job.
 * Any disclosure of this document to third parties is strictly prohibited.
 * #L%
 */

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BsnBookTransactionHistoryRepository
		extends JpaRepository<BsnBookTransactionHistoryRepository, Integer> {
	@Query("""
			SELECT
			(COUNT (*) > 0) AS isBorrowed
			FROM BookTransactionHistory bookTransactionHistory
			WHERE bookTransactionHistory.userId = :userId
			AND bookTransactionHistory.book.id = :bookId
			AND bookTransactionHistory.returnApproved = false
			""")
	boolean isAlreadyBorrowedByUser(@Param("bookId") Integer bookId, @Param("userId") String userId);

	@Query("""
			SELECT
			(COUNT (*) > 0) AS isBorrowed
			FROM BookTransactionHistory bookTransactionHistory
			WHERE bookTransactionHistory.book.id = :bookId
			AND bookTransactionHistory.returnApproved = false
			""")
	boolean isAlreadyBorrowed(@Param("bookId") Integer bookId);

	@Query("""
			SELECT transaction
			FROM BookTransactionHistory  transaction
			WHERE transaction.userId = :userId
			AND transaction.book.id = :bookId
			AND transaction.returned = false
			AND transaction.returnApproved = false
			""")
	Optional<BsnBookTransactionHistoryRepository> findByBookIdAndUserId(@Param("bookId") Integer bookId,
			@Param("userId") String userId);

	@Query("""
			SELECT transaction
			FROM BookTransactionHistory  transaction
			WHERE transaction.book.createdBy = :userId
			AND transaction.book.id = :bookId
			AND transaction.returned = true
			AND transaction.returnApproved = false
			""")
	Optional<BsnBookTransactionHistoryRepository> findByBookIdAndOwnerId(@Param("bookId") Integer bookId,
			@Param("userId") String userId);

	@Query("""
			SELECT history
			FROM BookTransactionHistory history
			WHERE history.userId = :userId
			""")
	Page<BsnBookTransactionHistoryRepository> findAllBorrowedBooks(Pageable pageable, String userId);

	@Query("""
			SELECT history
			FROM BookTransactionHistory history
			WHERE history.book.createdBy = :userId
			""")
	Page<BsnBookTransactionHistoryRepository> findAllReturnedBooks(Pageable pageable, String userId);
}
