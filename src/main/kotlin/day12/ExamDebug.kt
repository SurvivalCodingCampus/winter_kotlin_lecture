class Hero(val name: String, val power: Int)

fun main() {
    val heroes = mutableListOf<Hero>()
    val h1 = Hero("슈퍼맨", 100)
    val h2 = Hero("슈퍼맨", 100)
    heroes.add(h1)
    println(heroes.size)    // 1

    heroes.remove(h2)
    println(heroes.size)    // 1
}

/*
    일반 클래스에서 remove 메서드는 객체의 참조(메모리 주소)가 일치하는지 확인하여 객체를 제거한다.
    따라서 h1과 h2가 동일한 (name, power)값을 갖고 있더라도 서로 다른 객체로 취급되어
    서로 다른 메모리 주소를 가지므로 remove에서 삭제되지 않는다.
 */

/*
    데이터 클래스에서는 equals() 메서드가 자동으로 구현된다.
    equals()는 객체의 속성 값을 기준으로 두 객체가 같은지 비교한다.
    따라서 Hero("슈퍼맨", 100)과 같은 속성을 가진 두 객체는 값이 같으면 동일한 객체로 취급되므로
    h1과 h2는 같다고 판단되어 remove는 h1을 제거한다.
 */


//data class Hero(val name: String, val power: Int)
//
//fun main() {
//    val heroes = mutableListOf<Hero>()
//    val h1 = Hero("슈퍼맨", 100)
//    val h2 = Hero("슈퍼맨", 100)
//    heroes.add(h1)
//    println(heroes.size)      // 1
//
//    heroes.remove(h2)
//    println(heroes.size)      // 0
//}