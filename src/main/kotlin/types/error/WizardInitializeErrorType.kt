package org.example.types.error

import org.example.day05.Wizard

enum class WizardInitializeErrorType(override val message: String): InitializeErrorType {
    // 이름이 3글자 미만일 때
    SHORT_NAME("이름은 3글자 이상이어야 합니다."),
    // 완드가 없을 때
    NULL_WAND("완드가 없습니다."),
    // mp가 0 이하일 때
    INVALID_MP("마력은 0 이상이어야 합니다."),
}