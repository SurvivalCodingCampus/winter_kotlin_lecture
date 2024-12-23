package org.example.day05

class Wand(
    _name: String?,
    _power: Double,
) {
    var name: String? = if(_name == null || _name.length < 3)
        throw IllegalArgumentException("이름은 null이거나 3보다 작을 수 없습니다.") else _name // 이야 컴파일러가 똑똑해서 여기서 이미 null값 걸러지는 줄 알고서는 setter에서 타입을 바꿔버리네!
        set(value: String?) {                                                                             // 그럼 아예 내가 명시적으로 name의 타입을 String?로 바꿔버리지 뭐
            if (value == null || value.length < 3) { // 왜 always false야 윗 문장은 생성자의 매개변수를 집어넣어주는거고 set은 이후 수정시 집어넣어주는건데
                throw IllegalArgumentException("이름은 null이거나 3보다 작을 수 없습니다.")
            }
            field = value
        }

    var power = if(_power < 0.5 || _power > 100.0)
        throw IllegalArgumentException("power는 0.5보다 작거나 100.0보다 클 수 없습니다.") else _power
        set(value) {
            if (value < 0.5 || value > 100.0) {
                throw IllegalArgumentException("power는 0.5보다 작거나 100.0보다 클 수 없습니다.")
            }
            field = value
        }

    init {
        // 비록 init 블록이 주생성자 내부에서 동작한다고 하지만
        // 변수의 대입은 필드에서 먼저 이루어진 다음이다.
        // 즉, 먼저 넣어놓고 확인을 하는 것이라 아쉽다.
        // 그러므로 필드가 먼저 초기화 되니 필드에서부터 조건을 설정해 예외를 던져주게 구성을 했다.
    }
}