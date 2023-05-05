package com.kdu.JavaAssessment2.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenantId;
    private String bookName;
    private String book_category;
}