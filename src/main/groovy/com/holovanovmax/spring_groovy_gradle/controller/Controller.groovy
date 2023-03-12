package com.holovanovmax.spring_groovy_gradle.controller

import com.holovanovmax.spring_groovy_gradle.dao.UsersRepository
import com.holovanovmax.spring_groovy_gradle.entity.Users
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



@RestController
@RequestMapping("/api")
    class Controller {

    private final UsersRepository usersRepository;

   Controller(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users")
    ResponseEntity<List<Users>> getAllUsers(){
        return ResponseEntity.ok(this.usersRepository.findAll());
    }

    @PostMapping("/users")
    ResponseEntity<Users> createUser(@RequestBody Users users){
        return ResponseEntity.ok(this.userRepository.save(user));
    }

}
