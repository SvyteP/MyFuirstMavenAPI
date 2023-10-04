package com.example.MyFuirstMavenAPI.repository;

import com.example.MyFuirstMavenAPI.Entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepo extends CrudRepository<ToDoEntity,Long> {
}
