//package com.blog.blog.repository;
//
//import com.blog.blog.model.Posteo;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class PosteoRepository implements IposteoRepository {
//
//    private final List<Posteo> posteos = new ArrayList<>();
//
//    public PosteoRepository() {
////        posteos.add(new Posteo(1L, "Rutina de ejercicio", "Luz"));
////        posteos.add(new Posteo(2L, "ALimentos saludables", "Miguel"));
//    }
//
//    @Override
//    public List<Posteo> findAll() {
//        return posteos;
//    }
//
//    @Override
//    public Posteo findById(Long id) {
//        for (Posteo posteo: posteos){
//            if (posteo.getId_Posteo().equals(id)){
//                return posteo;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void save(Posteo posteo) {
//        posteos.add(posteo);
//    }
//}
