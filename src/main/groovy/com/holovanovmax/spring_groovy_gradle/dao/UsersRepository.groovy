package com.holovanovmax.spring_groovy_gradle.dao

import com.holovanovmax.spring_groovy_gradle.entity.Users
import org.springframework.data.mongodb.repository.MongoRepository

interface UsersRepository extends MongoRepository<Users, String> {

}