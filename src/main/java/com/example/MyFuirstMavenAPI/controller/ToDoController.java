package com.example.MyFuirstMavenAPI.controller;

import com.example.MyFuirstMavenAPI.Entity.ToDoEntity;
import com.example.MyFuirstMavenAPI.service.ToDoServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    @Autowired
    ToDoServic toDoServic;
    @PostMapping
    public ResponseEntity createTodo(@RequestBody ToDoEntity todo,
                                     @RequestParam Long userId)
    {
        try {

            return  ResponseEntity.ok().body(toDoServic.createTodo(todo,userId));
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body("Error Exception");
        }
    }
    @PutMapping
    public ResponseEntity createTodo(@RequestParam Long id)
    {
        try {

            return ResponseEntity.ok().body( toDoServic.complTodo(id));
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body("Error Exception");
        }
    }
}
