package com.blog.blog.controller;

import com.blog.blog.model.Posteo;
import com.blog.blog.service.PosteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posteos")
public class PosteoController {
    private final PosteoService posteoService;

    @Autowired
    public PosteoController(PosteoService posteoService) {
        this.posteoService = posteoService;
    }

    @GetMapping
    public List<Posteo> listaPosteos() {
        return posteoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Posteo> obtenerPorId(@PathVariable Long id) {
        return posteoService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarPosteo(@RequestBody Posteo posteo){
        posteoService.guardarPosteo(posteo);
        return ResponseEntity.ok("Posteo publicado con éxito");
    }

    @DeleteMapping ("/borrar/{id}")

    public ResponseEntity<String> deletePosteo(@PathVariable Long id) {
        posteoService.deletePosteo(id);
        return ResponseEntity.ok("Posteo elimina con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPosteo(@PathVariable Long id, @RequestBody Posteo posteoActualizado){
        posteoService.editarPosteo(id, posteoActualizado);
        return  ResponseEntity.ok("Posteo actualizada con exito");
    }
}
