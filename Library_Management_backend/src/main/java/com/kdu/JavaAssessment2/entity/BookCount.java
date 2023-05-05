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
@Table(name = "book_count")
public class BookCount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookCountId;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookId;
    private Integer count;
}
