package com.learn.kotlinums.enums

import org.springframework.http.HttpStatus

enum class ServiceErrorCode(val errorCode: String,val errorMessage: String,val httpStatus: HttpStatus) {
    BOOK_NOT_FOUND("LMS_001","Book not found for give id", HttpStatus.NOT_FOUND),
    DUPLICATE_USER_REGISTRATION("LMS_002", "User already exists. Registration not allowed",
        HttpStatus.CONFLICT),
    USER_NOT_FOUND("LMS_003", "User not found for given email",
    HttpStatus.NOT_FOUND),
    INVALID_CREDENTIALS("LMS_004", "Incorrect email or password, please try again",
        HttpStatus.UNAUTHORIZED)
}