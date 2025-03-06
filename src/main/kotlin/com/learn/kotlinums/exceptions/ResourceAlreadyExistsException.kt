package com.learn.kotlinums.exceptions

import com.learn.kotlinums.enums.ServiceErrorCode

class ResourceAlreadyExistsException(serviceErrorCode: ServiceErrorCode): AbstractServiceException(serviceErrorCode) {
}