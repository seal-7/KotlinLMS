package com.learn.kotlinums.exceptions

import com.learn.kotlinums.enums.ServiceErrorCode

abstract class AbstractServiceException(val serviceErrorCode: ServiceErrorCode) : Exception(serviceErrorCode.errorMessage) {

}