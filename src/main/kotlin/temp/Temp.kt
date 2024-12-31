import day06.SuperHero
import org.example.day04.Enemy
import org.example.day04.Sword

/* 코틀린 파일을 src/main/kotlin 속에 위치시켜야 한다.
 * 그리고 파일 명을 시작을 대문자로 하면 안된다.
 */

fun main() {
    val superHero = SuperHero("superhero", 10, 10, Sword("common sword", 5))
    val enemy = Enemy("common enemy", 10)

    superHero.attack(enemy)


}

fun timesTable(dan: Int) : Unit {   // 코틀린에서 함수명은 언더바를 쓰지 않는다.
    for(num in 1..9) {
        println("$dan * $num = ${dan * num}")
    }
}

fun test(temp: Int) : Int {
    val list = listOf("a", "b", "c")

    println("last index of list: ${list.lastIndex}")

    for(index in 0..2)
        println("list[$index]: ${list[index]}")
    return 0
}