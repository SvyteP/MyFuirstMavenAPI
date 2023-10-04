package com.example.MyFuirstMavenAPI.service;

import com.example.MyFuirstMavenAPI.Entity.ToDoEntity;
import com.example.MyFuirstMavenAPI.model.Todo;
import com.example.MyFuirstMavenAPI.repository.ToDoRepo;
import com.example.MyFuirstMavenAPI.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoServic {
    @Autowired
    private ToDoRepo toDoRepo;
    @Autowired
    private UserRepo userRepo;


    public Todo createTodo(ToDoEntity todo, Long userId){

        todo.setUser(userRepo.findById(userId).get());
        return Todo.toModel(toDoRepo.save(todo));
    }

    public Todo complTodo(Long id){
       ToDoEntity todo =  toDoRepo.findById(id).get();
       todo.setCompleted(!todo.isCompleted());
       return Todo.toModel(toDoRepo.save(todo));
    }
}
