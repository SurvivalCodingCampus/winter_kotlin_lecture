package day10

fun main() {
    val nums = mutableListOf<Int>(1,2,3,4)
    nums.add(10)
    println(nums)
    val pocket = Pocket()
    pocket.put("아무거나")
    println(pocket.get())

    val pocket2 = Pocket2<String>()
    pocket.put("아무거나2")
    println(pocket.get())
}

class Pocket {
    private var _data: Any? = null      // 제네릭을 사용하지 않고 Any 타입을 사용하여 모든 타입의 객체를 받을 수 있다.

    fun put(data: Any) {
        _data = data
    }

    fun get(): Any? = _data
}

class Pocket2<E> {                      // Pocket2 클래스는 제네릭 타입을 사용한다. E는 클래스의 타입 파라미터로, 클래스 인스턴스를 만들 때 E 타입을 지정할 수 있다.
    private var _data: E? = null

    fun put(data: E) {                  // put() 메소드는 data 파라미터로 E 타입을 받는다. 즉, Pocket2 객체에 데이터를 저장할 때, E 타입의 데이터만 넣을 수 있다.
        _data = data
    }

    fun get(): E? = _data

    // 메소드 오버로딩
    fun<E> get(a: E): E {               // 메소드 수준에서의 제네릭. 메소드 레벨에서 E는 이 메소드만의 제네릭 타입으로, 클래스의 제네릭 타입 E와는 별개로 사용된다.
        return a
    }
//<T: Any> nullable은 안된다는 의미
}