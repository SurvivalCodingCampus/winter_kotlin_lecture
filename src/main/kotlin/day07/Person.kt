package day07

/*
이름을 가지는 Person 클래스를 작성하시오. Person 은 반드시 이름을 포함해야 합니다.
이름이 ‘홍길동', ‘한석봉' 인 Person 인스턴스를 생성하고, List에 담습니다.
List에 담긴 모든 Person 인스턴스의 이름을 표시하시오.
*/

fun main() {
    val p1 = Person("홍길동")
    val p2 = Person("한석봉")
    val nameList = arrayListOf(p1, p2)

    println(nameList)
}

class Person(var name: String) {
    override fun toString(): String {
        return name
    }
}