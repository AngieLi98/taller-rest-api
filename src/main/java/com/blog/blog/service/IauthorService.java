package com.blog.blog.service;

import com.blog.blog.model.Author;

import java.util.List;

public interface IauthorService {
    List<Author> obtenerTodos();
    Author guardarAuthor(Author author);
    Author agregarPosteo(Long posteoId, Author author);
}
