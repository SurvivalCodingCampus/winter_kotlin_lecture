package org.example.day05

import org.example.domain.error.InitializeError
import org.example.domain.types.error.WandInitializeErrorType

class Wand(
    name: String,
    power: Double,
) {
    var name: String = name
        set(value) {
            require(value.length < 3) {
                throw InitializeError(WandInitializeErrorType.SHORT_NAME)
            }
            field = value
        }

    var power: Double = power
        set(value) {
            require(value !in 0.5 .. 100.0) {
                throw InitializeError(WandInitializeErrorType.POWER_RANGE)
            }
            field = value
        }
}



