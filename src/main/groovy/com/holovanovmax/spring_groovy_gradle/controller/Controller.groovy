package com.holovanovmax.spring_groovy_gradle.controller

import com.holovanovmax.spring_groovy_gradle.dao.UsersRepository
import com.holovanovmax.spring_groovy_gradle.entity.Users
import com.holovanovmax.spring_groovy_gradle.request.UsersRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class Controller {

    private final UsersRepository usersRepository

    Controller(UsersRepository usersRepository) {
        this.usersRepository = usersRepository
    }

    @GetMapping("/users")
    ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(this.usersRepository.findAll())
    }

    @PostMapping("/users")
    ResponseEntity<Users> createUsers(@RequestBody UsersRequest usersRequest) {
        Users users = new Users()

        return ResponseEntity.status(201).body(this.usersRepository.save(users))

    }

    @GetMapping("/users/{id}")
    ResponseEntity getUsersById(@PathVariable String id) {
        Optional<Users> users = this.usersRepository.findById(id)

        if (users.isPresent()) {
            return ResponseEntity.ok(users.get())
        } else {
            return ResponseEntity.ok("The product with " + id + " was not found.")
        }
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity deleteUsersById(@PathVariable String id) {
        Optional<Users> product = this.usersRepository.findById(id)

        if (product.isPresent()) {
            this.usersRepository.deleteById(id)
            return ResponseEntity.ok("Done")
        } else {
            return ResponseEntity.ok("The product with " + id + " was not found.")
        }
    }

}

