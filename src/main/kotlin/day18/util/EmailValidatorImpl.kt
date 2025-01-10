package org.example.day18.util

import org.example.day18.error.EmailError

/**
 * 테스트 요구사항
 * - 빈 문자열 검증
 * - @ 없는 경우 검증
 * - 잘못된 도메인 검증
 * - 정상 이메일 검증
 */
class EmailValidatorImpl : EmailValidator {
    override fun isValid(email: String): Result<Unit> {
        return when {
            email.isEmpty() -> Result.Error(EmailError.EmptyEmail)
            !email.contains("@") -> Result.Error(EmailError.NoAtSign)
            !email.endsWith(".com") || !email.endsWith(".net") || !email.endsWith(".org") -> Result.Error(EmailError.InvalidDomain)
            else -> Result.Success(Unit)
        }
    }
}