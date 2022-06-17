/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.user.service.controller;

import com.tutorial.user.service.entity.User;
import com.tutorial.user.service.model.Bike;
import com.tutorial.user.service.model.Car;
import com.tutorial.user.service.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */

@RestController
@RequestMapping("/user")
public class UserController {
    
    
    @Autowired
    UserService userService;
    
    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users=userService.getAll();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }
    
    
    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id){
        User user=userService.getUserById(id);
        if(user==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }
    
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User userNew=userService.save(user);
        if(userNew==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userNew);
    }
    
    
    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getCars(@PathVariable("userId") int userId){
        User user=userService.getUserById(userId);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        List<Car> cars=userService.getCars(userId);
        return ResponseEntity.ok(cars);
    }
    
    @GetMapping("/bikes/{userId}")
    public ResponseEntity<List<Bike>> getBike(@PathVariable("userId") int userId){
        User user=userService.getUserById(userId);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        List<Bike> bikes=userService.getBikes(userId);
        return ResponseEntity.ok(bikes);
    }
}
