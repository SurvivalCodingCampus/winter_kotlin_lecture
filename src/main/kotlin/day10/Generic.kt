package day10

fun main() {
    val nums = mutableListOf<Int>(1,2,3,4)
    nums.add(10)

    val pocket = Pocket2<Int>()

//    pocket.put("아무거나")
    println(pocket.get())
}

class Pocket {      // 제네릭 정의한거처럼 제약이 안걸리고 정말 아무거나 올 수 있다~
    private var _data: Any? = null

    fun put(data: Any) {
        _data = data
    }

    fun get(): Any? = _data
}

class Pocket2<E> {
    private var _data: E? = null

    fun put(data: E) {
        _data = data
    }

    fun get(): E? = _data

    fun<E> get(a: E): E {
        return a
    }
//<T: Any> nullable은 안된다는 의미
}