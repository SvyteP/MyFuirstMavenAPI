package com.example.MyFuirstMavenAPI.service;

import com.example.MyFuirstMavenAPI.Entity.UserEntity;
import com.example.MyFuirstMavenAPI.exeption.UserAlreadyExistException;
import com.example.MyFuirstMavenAPI.exeption.UserNotFoundException;
import com.example.MyFuirstMavenAPI.model.User;
import com.example.MyFuirstMavenAPI.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServic {
    @Autowired
    private UserRepo userRepo;
    public UserEntity registration (UserEntity user) throws UserAlreadyExistException {

        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("This name is reserved!");
        }

        return userRepo.save(user);
    }

    public User GetOne (Long id) throws UserNotFoundException {
        if(userRepo.findById(id).isEmpty()){
            throw new UserNotFoundException("User not found!");
        }
        return User.toModel(userRepo.findById(id).get());
    }

    public void delete(Long id){
        userRepo.findById(id).orElseThrow();
        userRepo.deleteById(id);

    }
}
