fun main() {
    val hong = Person(name = "홍길동", age=30)
    val han = Person(name = "한석봉")

    val nameOfList = mutableListOf<String>()
    nameOfList.add(hong.name)
    nameOfList.add(han.name)

    nameOfList.forEach(::println)
    nameOfList.forEach { name ->
        println(name)
    }

}