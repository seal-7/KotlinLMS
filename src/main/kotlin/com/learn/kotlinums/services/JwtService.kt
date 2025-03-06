package com.learn.kotlinums.services

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class JwtService(@Value("lms.user.token.secret") val tokenSecret: String) {

    fun createJwt(payload: String): String {
        val secretKey = "your-secret-key".toByteArray()

        return JWT.create()
            .withIssuer("lms")
            .withIssuedAt(Date(System.currentTimeMillis()))
            .withExpiresAt(Date(System.currentTimeMillis() + 3600000)) // 1 hour
            .withPayload(payload)
            .sign(Algorithm.HMAC256(secretKey))

    }
}