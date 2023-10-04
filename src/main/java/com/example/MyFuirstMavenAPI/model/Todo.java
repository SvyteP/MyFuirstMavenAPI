package com.example.MyFuirstMavenAPI.model;

import com.example.MyFuirstMavenAPI.Entity.ToDoEntity;

public class Todo {
    private Long id;
    private String title;
    private boolean completed;
    public static Todo toModel(ToDoEntity todo){
        Todo model =new Todo();
        model.setId(todo.getId());
        model.setTitle(todo.getTitle());
        model.setCompleted(todo.isCompleted());
        return model;
    }
    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
