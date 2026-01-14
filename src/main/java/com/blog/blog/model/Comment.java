package com.blog.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Commets")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Comment;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "posteo_id")
    @JsonBackReference
    private Posteo usuario;

    public Comment() {
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
    }

    public Comment(Long id_Comment, String text, LocalDate createdAt) {
        this.id_Comment = id_Comment;
        this.text = text;
        this.createdAt = createdAt;
    }

    public Long getId_Comment() {
        return id_Comment;
    }

    public void setId_Comment(Long id_Comment) {
        this.id_Comment = id_Comment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

}
