package org.example.error

import org.example.types.error.InitializeErrorType


class InitializeError(type: InitializeErrorType): IllegalArgumentException(type.message)
