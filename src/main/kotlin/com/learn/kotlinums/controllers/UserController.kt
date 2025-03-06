package com.learn.kotlinums.controllers;

import com.learn.kotlinums.models.requests.LoginUserRequest
import com.learn.kotlinums.models.requests.RegisterUserRequest
import com.learn.kotlinums.services.UserManagementService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = ["/users"])
class UserController(val userManagementService: UserManagementService) {

    @PostMapping(value = ["/register"])
    fun registerUser(@RequestBody registerUserRequest: RegisterUserRequest): ResponseEntity<Unit> {
        userManagementService.registerUser(registerUserRequest.email, registerUserRequest.password)
        return ResponseEntity.ok().build()
    }

    @PostMapping(value = ["/login"])
    fun loginUser(@RequestBody loginUserRequest: LoginUserRequest): ResponseEntity<String> {
        val token = userManagementService.loginUser(loginUserRequest.email, loginUserRequest.password)
        return ResponseEntity.ok(token)
    }
}
