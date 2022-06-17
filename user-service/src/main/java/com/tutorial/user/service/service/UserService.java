/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.user.service.service;

import com.tutorial.user.service.entity.User;
import com.tutorial.user.service.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    public List<User> getAll(){
        return userRepository.findAll();
    }
    
    
    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }
    
    public User save(User user){
        User userNew =userRepository.save(user);
        return userNew;
    }
    
}
