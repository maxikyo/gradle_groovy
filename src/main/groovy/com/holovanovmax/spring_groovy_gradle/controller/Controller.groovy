package com.holovanovmax.spring_groovy_gradle.controller

import com.holovanovmax.spring_groovy_gradle.dao.UsersRepository
import com.holovanovmax.spring_groovy_gradle.entity.Users
import com.holovanovmax.spring_groovy_gradle.request.UsersRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


//!first variant of controller!
@RestController
    class Controller {

    private final UsersRepository usersRepository;

    Controller(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users")
    ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(this.usersRepository.findAll());
    }

    @PostMapping("/users")
    ResponseEntity<Users> createProduct(@RequestBody UsersRequest usersRequest) {
        Users users = new Users();

        return ResponseEntity.status(201).body(this.usersRepository.save(users));

    }

    @GetMapping("/users/{id}")
    ResponseEntity getProductById(@PathVariable String id) {
        Optional<Users> product = this.usersRepository.findById(id);

        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.ok("The product with " + id + " was not found.");
        }
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity deleteProductById(@PathVariable String id) {
        Optional<Users> product = this.usersRepository.findById(id);

        if (product.isPresent()) {
            this.usersRepository.deleteById(id);
            return ResponseEntity.ok("Done");
        } else {
            return ResponseEntity.ok("The product with " + id + " was not found.");
        }
    }

}
////!Second variant of controller!
//@RestController
//@RequestMapping("api")
//class Controller {
//
//    @Autowired
//    UsersRepository usersService
//
//    @GetMapping
//    List<Users> getAllUsers() {
//    usersService.findAll()
//    }
//
//    @PostMapping
//    Users saveUsers(@RequestBody Users users) {
//        usersService saveUsers(Users)
//    }
//
//    @PutMapping("/{usersId}")
//    Users updateUsers(PathVariable usersId, @RequestBody Users users){
//        usersService.updateUsers(usersId, users)
//    }
//
//    @DeleteMapping("/{usersId}")
//    deleteUsers(@PathVariable usersId){
//        usersService.findAllById(usersId)
//    }
//
//    @GetMapping("/{usersId}")
//    Users getUsersById (@PathVariable usersId){
//        usersService.findAllById(usersId)
//    }
//
//}
