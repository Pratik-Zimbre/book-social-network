package com.personal.book.entity;

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

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BsnBookTransactionHistory extends BsnBaseEntity {

    // @ManyToOne
    @Column(name = "user_id")
    private String userId;
//    @ManyToOne
//    @JoinColumn(name = "book_id")
//    private BsnBook book;
    private boolean returned;
    private boolean returnApproved;
}
