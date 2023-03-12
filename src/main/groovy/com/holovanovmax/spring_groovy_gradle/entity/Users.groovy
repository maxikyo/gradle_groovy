package com.holovanovmax.spring_groovy_gradle.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document ("users")
class Users {



    @Id
    private def id

    private def email

    private def name

    Users() {

    }

    @Override
    String toString() {
        return "Users{" +
                "id=" + id +
                ", email=" + email +
                ", name=" + name +
                '}';
    }
}
