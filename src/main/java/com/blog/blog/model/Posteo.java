package com.blog.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "posteos")
public class Posteo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Posteo;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;

    @Column(nullable = false, updatable = false)
    private LocalDate fecha_creacion;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author creador;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Comment> comments;

    public Posteo() {
    }

    @PrePersist
    protected void onCreate() {
        this.fecha_creacion = LocalDate.now();
    }

    public Posteo(Long id_Posteo, String titulo, String contenido) {
        this.id_Posteo = id_Posteo;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public Long getId_Posteo() {
        return id_Posteo;
    }

    public void setId_Posteo(Long id_Posteo) {
        this.id_Posteo = id_Posteo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
