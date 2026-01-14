package com.blog.blog.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Author;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Posteo> posteos;

    public Author() {
    }

    public Author(Long id_Author, String name, String email) {
        this.id_Author = id_Author;
        this.name = name;
        this.email = email;
    }

    public Long getId_Author() {
        return id_Author;
    }

    public void setId_Author(Long id_Author) {
        this.id_Author = id_Author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
