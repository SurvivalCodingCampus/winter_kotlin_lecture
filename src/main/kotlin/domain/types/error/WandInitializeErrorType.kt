package org.example.domain.types.error

enum class WandInitializeErrorType(override val message: String) : InitializeErrorType {
    SHORT_NAME("이름은 3글자 이상이어야 합니다."),
    POWER_RANGE("파워는 0.5 이상 100.0 이하여야 합니다.");
}