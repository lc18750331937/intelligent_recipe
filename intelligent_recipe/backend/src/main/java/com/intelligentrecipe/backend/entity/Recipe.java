package com.intelligentrecipe.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "average_rating", nullable = false)
    private Double averageRating;

    @Column(name = "favorite_count", nullable = false)
    private Integer favoriteCount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}