package org.example.day05

import org.example.domain.error.InitializeError
import org.example.domain.types.error.WizardInitializeErrorType

class Wizard(
    name: String,
    hp: Int,
    mp: Int,
    wand: Wand?,
) {
    var name: String = name
        set(value) {
            require(value.length < 3) {
                throw InitializeError(WizardInitializeErrorType.SHORT_NAME)
            }
            field = value
        }

    var mp: Int = mp
        set(value) {
            require(value < 0) {
                throw InitializeError(WizardInitializeErrorType.INVALID_MP)
            }
            field = value
        }

    var hp: Int = hp
        set(value) {
            if(value < 0) {
                field = 0;
            }
            field = value
        }

    var wand: Wand? = wand
        set(value) {
            require(value == null) {
                throw InitializeError(WizardInitializeErrorType.NULL_WAND)
            }
            field = value
        }
}