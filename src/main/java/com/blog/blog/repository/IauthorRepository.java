package com.blog.blog.repository;

import com.blog.blog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IauthorRepository extends JpaRepository<Author, Long> {
}
