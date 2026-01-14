package com.blog.blog.service;

import com.blog.blog.model.Comment;
import com.blog.blog.model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IposteoService {
    List<Posteo> obtenerTodos();
    Optional<Posteo> obtenerPorId(Long id);

    Posteo guardarPosteo(Posteo posteo);

    void deletePosteo(Long id);
    void editarPosteo(Long id, Posteo posteoActualizado);

    Posteo agregarComentario(Long posteoId, Comment comment);
}
