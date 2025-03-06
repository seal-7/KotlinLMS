package com.learn.kotlinums.repositories;

import com.learn.kotlinums.models.User;
import org.springframework.stereotype.Repository


@Repository
class UsersRepository(val users: ArrayList<User>) {

    fun insert(user: User) {
        users.add(user)
    }

    fun findByEmail(email: String): User? {
        return users.findLast { it.email == email }
    }

    fun findById(id: String): User? {
        return users.findLast { it.id == id }
    }

    fun delete(id: String) {
        users.removeIf { it.id == id }
    }
}
