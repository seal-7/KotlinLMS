package com.learn.kotlinums.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.learn.kotlinums.enums.ServiceErrorCode
import com.learn.kotlinums.exceptions.ResourceAlreadyExistsException
import com.learn.kotlinums.exceptions.ResourceNotAvailableException
import com.learn.kotlinums.exceptions.UnauthorizedException
import com.learn.kotlinums.models.User
import com.learn.kotlinums.repositories.UsersRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserManagementService(val usersRepository: UsersRepository, val jwtService: JwtService, val objectMapper: ObjectMapper) {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    fun registerUser(email: String, password: String) {
        usersRepository.findByEmail(email)?.let { user ->
            log.error("User already exist with email: $email, existingUser: $user")
            throw ResourceAlreadyExistsException(ServiceErrorCode.DUPLICATE_USER_REGISTRATION)
        }

        val user = User(UUID.randomUUID().toString(), email, password)
        usersRepository.insert(user)
    }

    fun loginUser(email: String, password: String): String {
        val user = usersRepository.findByEmail(email)?: throw ResourceNotAvailableException(ServiceErrorCode.USER_NOT_FOUND)
        require (user.password == password) {
            throw UnauthorizedException(ServiceErrorCode.INVALID_CREDENTIALS)
        }
        val tokenPayloadString = objectMapper.writeValueAsString(mapOf(Pair("payload", user)))
        return jwtService.createJwt(tokenPayloadString)
    }
}