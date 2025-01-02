package day11

import org.example.day11.stringToInt
import org.junit.Assert.*
import org.junit.Test

class ExceptionExamKtTest {
    @Test
    fun `문자열이 정수로 변환 가능하면 해당 정수를 반환해야 함`() {
        val number = stringToInt("10")
        assertEquals(10, number)
    }

    @Test
    fun `문자열이 소수점이 있는 숫자일 경우 0을 반환해야 함`() {
        val number = stringToInt("10.5")
        assertEquals(0, number)
    }

    @Test
    fun `문자열이 비어있거나 숫자가 아닐 경우 기본값 0을 반환해야 함`() {
        val number = stringToInt("")
        val number2 = stringToInt("abc")
        assertEquals(0, number)
        assertEquals(0, number2)
    }

    @Test
    fun `음수 문자열도 변환 가능해야 함`() {
        val number = stringToInt("-10")
        assertEquals(-10, number)
    }
}