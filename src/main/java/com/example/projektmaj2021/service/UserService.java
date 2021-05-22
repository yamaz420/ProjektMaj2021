package com.example.projektmaj2021.service;

import com.example.projektmaj2021.entity.User;
import com.example.projektmaj2021.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //spara User med hjälp av inbyggd metod från extended interface JpaRepository
    public void saveUser(User user){
        userRepository.save(user);
    }

    //visa alla users med hjälp av inbyggd metod från JpaRepository
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


}
