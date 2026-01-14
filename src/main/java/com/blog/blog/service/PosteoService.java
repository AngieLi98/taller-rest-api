package com.blog.blog.service;

import com.blog.blog.model.Comment;
import com.blog.blog.model.Posteo;
import com.blog.blog.repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    @Override
    public Optional<Posteo> obtenerPorId(Long id) {
        Posteo posteo = posteoRepository.findById(id)
                .orElseThrow();

        return Optional.of(posteo);
    }

    @Override
    public Posteo guardarPosteo(Posteo posteo) {
        return posteoRepository.save(posteo);
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
        Posteo posteo = posteoRepository.findById(posteoId)
                .orElseThrow(() -> new RuntimeException("Posteo no encontrada"));

        comment.setUsuario(posteo);
        posteo.getComments().add(comment);

        return posteoRepository.save(posteo);
    }

}
