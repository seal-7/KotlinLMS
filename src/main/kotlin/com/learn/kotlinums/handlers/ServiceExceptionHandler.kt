package com.learn.kotlinums.handlers

import com.learn.kotlinums.exceptions.AbstractServiceException
import com.learn.kotlinums.models.responses.ServiceErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ServiceExceptionHandler {

    @ExceptionHandler
    fun handleServiceExceptions(exception: AbstractServiceException): ResponseEntity<ServiceErrorResponse> {
        val serviceErrorResponse = ServiceErrorResponse(System.currentTimeMillis(), exception.serviceErrorCode.errorCode,
            exception.serviceErrorCode.errorMessage)
        return ResponseEntity(serviceErrorResponse, exception.serviceErrorCode.httpStatus)
    }
}