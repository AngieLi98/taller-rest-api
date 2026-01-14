package com.blog.blog.service;

import com.blog.blog.model.Comment;
import com.blog.blog.model.Posteo;
import com.blog.blog.repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IposteoService{

    private final IposteoRepository posteoRepository;

    @Autowired
    public PosteoService(IposteoRepository posteoRepository) {
        this.posteoRepository = posteoRepository;
    }

    @Override
    public List<Posteo> obtenerTodos() {
        return posteoRepository.findAll();
    }

    @Override
    public Optional<Posteo> obtenerPorId(Long id) {
        return posteoRepository.findById(id);
    }

    @Override
    public Posteo guardarPosteo(Posteo posteo) {
        posteoRepository.save(posteo);
        return posteo;
    }

    @Override
    public void deletePosteo(Long id) {
        posteoRepository.deleteById(id);
    }

    @Override
    public void editarPosteo(Long id, Posteo posteoActualizado) {
        //Saber si exsite
        Posteo posteoExistente = posteoRepository.findById(id).orElse(null);

        if (posteoExistente != null){
            //Actualizar los campos de posteo existente
            posteoExistente.setTitulo(posteoActualizado.getTitulo());
            posteoExistente.setContenido(posteoActualizado.getContenido());

            // Guardo al posteo actualziado
            posteoRepository.save(posteoExistente);
        } else {
            throw new RuntimeException("Posteo no encontrado con el id: " + id);
        }
    }

    @Override
    public Posteo agregarComentario(Long posteoId, Comment comment) {
        return null;
    }
}
