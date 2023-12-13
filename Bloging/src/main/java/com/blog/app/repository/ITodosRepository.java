package com.blog.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.entity.Todos;
import com.blog.app.entity.User;

public interface ITodosRepository extends JpaRepository<Todos, Long>   {
    public List<Todos> findByUser(User user);
}
