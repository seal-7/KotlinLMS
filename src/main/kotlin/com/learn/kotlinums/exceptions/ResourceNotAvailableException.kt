package com.learn.kotlinums.exceptions

import com.learn.kotlinums.enums.ServiceErrorCode

class ResourceNotAvailableException(serviceErrorCode: ServiceErrorCode): AbstractServiceException(serviceErrorCode) {
}