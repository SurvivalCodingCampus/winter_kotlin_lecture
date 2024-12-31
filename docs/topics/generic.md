## 제네릭, 열거형

### 타입이 없을때의 문제점 
1) 런타임 에러가 나기 쉽다.
2) IDE가 컴파일 에러를 미리 찾을 수 없다.


### 제네릭
- 사용하는 시점에 타입을 원하는 형태로 정의할 수 있음
- 타입 안전 효과 

```text
List<E> class

Map<K, V> class
```

```kotlin
// 제네릭을 사용한 PocketClass

class Pocket<E> {
    private var _data: E?= null
    
    fun put(data: E) {
        _data = data
    }
    
    fun get(): E? = _data
}
```


### Advanced
- 읽기전용(공변성)
```kotlin
class Pocket<out T> // kotlin 
List<? extends T>   // Java
```

- 쓰기전용(반공변성)
```kotlin
class Pocket<in T> // kotlin
List<? super T> // Java
```

- 둘다됨(무변성)
```kotlin
class Pocket<T> // Kotlin, Java
```


### 결론
1. 기본적으로 그냥 일반 제네릭 사용
```kotlin
class Box<T>
```

2. 읽기 전용이 필요할 때 out
```kotlin
// List는 내부적으로 out T로 되어있음
val numbers: List<Number> = listOf<Int>(1, 2, 3)
```

3. in은 거의 사용하지 않음
a. Kotlin 표준 라이브러리 개발
b. 앱 개발에 불필요


### 열거형(enum) - 정해둔 값만 넣어둘 수 있는 타입


### enum을 정의하여 세 가지 상태로 제약을 건 코드 
```kotlin
enum class AuthState {
    AUTHENTICATED, UNAUTHENTICATED, UNKNOWN
}

fun something(authState: AuthState) {
    when(authState) {
        AuthState.AUTHENTICATED -> println("Authenticated")
        AuthState.UNAUTHENTICATED -> println("Unauthenticated")
        AuthState.UNKNOWN -> println("unknown")
    }
}

```
-> enum 클래스는 when과 조합으로 모든 처리 강제 가능




