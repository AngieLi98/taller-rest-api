package com.blog.blog.service;

import com.blog.blog.model.Author;
import com.blog.blog.repository.IauthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorService implements IauthorService{

    private final IauthorRepository authorRepository;

    @Autowired
    public AuthorService(IauthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> obtenerTodos() {
        return List.of();
    }

    @Override
    public Author guardarAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author agregarPosteo(Long posteoId, Author author) {
        return authorRepository.save(author);
    }
}
