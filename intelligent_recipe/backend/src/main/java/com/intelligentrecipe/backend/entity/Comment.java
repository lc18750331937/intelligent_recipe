package com.intelligentrecipe.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user; // 评论用户

    @ManyToOne
    private Recipe recipe; // 评论菜谱

    private String content; // 评论内容
    private LocalDateTime timestamp; // 评论时间
    private boolean approved; // 是否审核通过
    private boolean pinned; // 是否置顶
}