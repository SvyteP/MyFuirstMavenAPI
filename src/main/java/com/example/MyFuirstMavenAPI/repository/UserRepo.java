package com.example.MyFuirstMavenAPI.repository;

import com.example.MyFuirstMavenAPI.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity,Long> {
     UserEntity findByUsername(String username);
}
