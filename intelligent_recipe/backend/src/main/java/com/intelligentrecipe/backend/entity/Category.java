package com.intelligentrecipe.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 分类名称

    @OneToMany(cascade = CascadeType.ALL)
    private List<Category> subcategories; // 子分类
}