package com.example.MyFuirstMavenAPI.controller;

import com.example.MyFuirstMavenAPI.Entity.UserEntity;
import com.example.MyFuirstMavenAPI.exeption.UserAlreadyExistException;

import com.example.MyFuirstMavenAPI.exeption.UserNotFoundException;
import com.example.MyFuirstMavenAPI.service.UserServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class Controller {
    @Autowired
    private UserServic userServic;
    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userServic.registration(user);
            return ResponseEntity.ok().body("User is registered");

        }
        catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error Exception");
        }

    }
    @GetMapping
    public ResponseEntity getUser(@RequestParam Long id ){
        try {

            return ResponseEntity.ok().body(userServic.GetOne(id));
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error Exception");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            userServic.delete(id);
            return ResponseEntity.ok().body("User delete");
        }
        catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body("User not found");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error Exception");
        }
    }
}
