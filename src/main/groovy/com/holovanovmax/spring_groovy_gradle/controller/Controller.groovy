package com.holovanovmax.spring_groovy_gradle.controller

import com.holovanovmax.spring_groovy_gradle.dao.UsersRepository
import com.holovanovmax.spring_groovy_gradle.entity.Users
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
//@RestController
//@RequestMapping("api/")
//    class Controller {
//
//    private final UsersRepository usersRepository;
//
//   Controller(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }
//
//    @GetMapping("/users")
//    ResponseEntity<List<Users>> getAllUsers(){
//        return ResponseEntity.ok(this.usersRepository.findAll());
//    }
//
//    @PostMapping("/users")
//    ResponseEntity<Users> createUsers(@RequestBody Users users) {
//        return ResponseEntity.ok(this.usersRepository.save(users))
//    }
//
//}

//!Second variant of controller!
@RestController
@RequestMapping("api")
class Controller {

    @Autowired
    UsersRepository usersService

    @GetMapping
    List<Users> getAllUsers() {
    usersService.findAll()
    }

    @PostMapping
    Users saveUsers(@RequestBody Users users) {
        usersService saveUsers(Users)
    }

    @PutMapping("/{usersId}")
    Users updateUsers(PathVariable usersId, @RequestBody Users users){
        usersService.updateUsers(usersId, users)
    }

    @DeleteMapping("/{usersId}")
    deleteUsers(@PathVariable usersId){
        usersService.findAllById(usersId)
    }

    @GetMapping("/{usersId}")
    Users getUsersById (@PathVariable usersId){
        usersService.findAllById(usersId)
    }

}
