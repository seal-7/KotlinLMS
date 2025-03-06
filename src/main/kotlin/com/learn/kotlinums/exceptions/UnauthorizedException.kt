package com.learn.kotlinums.exceptions

import com.learn.kotlinums.enums.ServiceErrorCode

class UnauthorizedException(serviceErrorCode: ServiceErrorCode): AbstractServiceException(serviceErrorCode) {
}