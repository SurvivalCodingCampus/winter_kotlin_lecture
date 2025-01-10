import day06.SuperHero
import org.example.day04.Enemy
import org.example.day04.Sword
import java.time.LocalDate

/* 코틀린 파일을 src/main/kotlin 속에 위치시켜야 한다.
 * 그리고 파일 명을 시작을 대문자로 하면 안된다.
 */

fun main() {
    val text = "2020-01-01"

    println(LocalDate.parse(text) is LocalDate)
}