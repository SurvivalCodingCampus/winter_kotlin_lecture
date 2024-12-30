# 제네릭, 열거형, 문자열 조작

## 제네릭(Generic)

- 사용하는 시점에 타입을 원하는 형태로 정의할 수 있음
- 타입 안전(type safe) 효과

```kotlin
//제네릭을 사용하지 않은 Pocket 클래스
class Pocket {
    private var _data: Any? = null

    fun put(data: Any) {
        _data = data
    }

    fun get(): Any? = _data
}
```

```kotlin
//제네릭을 사용한 Pocket 클래스
//가장 많이 사용하는 형태
class Pocket<E> {
    private var _data: E? = null

    fun put(data: E) {
        _data = data
    }

    fun get(): E? = _data
}
```

```kotlin
//이용 가능한 타입에 제약을 추가한 Pocket 클래스
class Pocket<E: Book> {
    private var _data: E? = null

    fun put(data: E) {
        _data = data
    }

    fun get(): E? = _data
}
```

## 열거형(enum)

- 정해 둔 값만 넣어둘 수 있는 타입
- 타입 안정성: 값의 집합을 제한하여 코드의 안정성 증가.
- 가독성 향상: 상수 집합을 의미 있는 이름으로 정의.
- 유지보수성 증가: 추가적인 속성, 메서드를 제공하여 기능 확장.

## 문자열 조작

- 한번 저장해 놓은 String 글자는 재활용 되서 “=== “비교하면 true 나온다
- String은 불변
