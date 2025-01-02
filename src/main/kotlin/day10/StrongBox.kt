package day10

/* 다음 조건을 만족하는 금고인 StrongBox 클래스를 정의하시오.
금고 클래스에 담는 인스턴스의 타입은 미정
금고에는 1개의 인스턴스를 담을 수 있음
put() 메서드로 인스턴스를 저장하고 get() 메서드로 인스턴스를 얻을 수 있음
get() 으로 얻을 때는 별도의 타입 캐스팅을 사용하지 않아도 됨 */

class StrongBox<E>(private val keyType: KeyType) {
    private var _data: E? = null
    private var count = 0

    fun put(data: E) {
        _data = data
    }

    fun get(): E? {
        count++
        return if (count > keyType.maxAttempts) {
            _data
        } else {
            null
        }
    }
}

/*
연습문제 1에서 작성한 StrongBox 클래스에 열쇠의 종류를 나타내는 열거형 KeyType을 정의하고,
다음 내용을 반영하여 StrongBox 클래스를 수정하시오.

열쇠의 종류를 나타내는 필드 변수
열쇠의 종류를 받는 생성자

단, 열쇠의 종류는 다음 4종류로 한정한다. 각 열쇠 종류는 시도횟수의 한도가 정해져 있다.
padlock    (1,024회)
button      (10,000회)
dial             (30,000회)
finger       (1,000,000회)

금고에서 get() 메서드를 호출할 때 마다 사용횟수를 카운트하고 각 열쇠의 사용횟수에 도달하기 전에는 null을 리턴한다.

예를 들어, 쿠팡에서 이 금고를 주문할 때 키 타입을 정해서 주문을 한다.
금고에 넣고 싶은 것을 넣을 수 있다.
키 타입에 따라 정해진 횟수만큼은 열리지 않는다.
횟수에 도달하면 잠금이 해제되어 열린다.
*/

enum class KeyType(val maxAttempts: Int) {
    PADLOCK(1024),
    BUTTON(10000),
    DIAL(30000),
    FINGER(1000000)
}
