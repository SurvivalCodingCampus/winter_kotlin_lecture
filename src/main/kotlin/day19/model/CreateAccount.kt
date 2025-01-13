package day19.model

data class CreateAccount(
    val name: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
)
