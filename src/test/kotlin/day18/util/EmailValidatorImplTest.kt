package day18.util

import org.example.day18.error.EmailError
import org.example.day18.util.EmailValidatorImpl
import org.example.day18.util.Result
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class EmailValidatorImplTest {
    @Test
    fun isValid() {
        val emailValidator = EmailValidatorImpl()

        val emptyStringResult = emailValidator.isValid("")

        when (emptyStringResult) {
            is Result.Success -> fail("빈 문자열은 유효하지 않습니다.")
            is Result.Error -> assertEquals(
                "빈 문자열을 넣으면 EmailError.EmptyEmail 을 반환 해야 한다.",
                EmailError.EmptyEmail,
                emptyStringResult.e
            )
        }

        val noAtSignResult = emailValidator.isValid("test.com")

        when (noAtSignResult) {
            is Result.Success -> fail("@ 문자가 없는 경우 유효하지 않습니다.")
            is Result.Error -> assertEquals(
                "@ 문자가 없으면 EmailError.NoAtSign 을 반환 해야 한다.",
                EmailError.NoAtSign,
                noAtSignResult.e
            )
        }

        val invalidDomainResult = emailValidator.isValid("aaa.bbb@ccc")

        when (invalidDomainResult) {
            is Result.Success -> fail("도메인이 잘못된 경우 유효하지 않습니다.")
            is Result.Error -> assertEquals(
                "도메인이 잘못되면 EmailError.InvalidDomain 을 반환 해야 한다.",
                EmailError.InvalidDomain,
                invalidDomainResult.e
            )
        }


    }

}