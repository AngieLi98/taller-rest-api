package com.blog.blog.repository;

import com.blog.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IcommentRepository extends JpaRepository<Comment, Long> {
}
