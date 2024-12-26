package org.example.domain.error

import org.example.domain.types.error.InitializeErrorType


class InitializeError(type: InitializeErrorType): IllegalArgumentException(type.message)
