package com.example.todo.repository;

import com.example.todo.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<ToDo, Long> {
}
