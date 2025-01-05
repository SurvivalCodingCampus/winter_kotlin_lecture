package day13

import kotlinx.coroutines.test.runTest
import org.junit.Test

class BirdChirpingKtTest {

    @Test
    fun chirpTest() = runTest {
        // 뭘 어떻게 테스트 해야 잘됐다고 소문이 날까
        chirping()
    }
}