### 일일 학습 기록 (상세)
```markdown
# 2024-12-30

## 📚 오늘 배운 내용
- 제네릭 (generic)
- 열거형 (enum class)

### 정리

### 전체
#### - 타입이 없을때의 문제점
1. 런타임 에러가 나기 쉽다.
2. IDE가 컴파일 에러를 미리 찾을 수 없다.

#### - 제네릭 (Generic)
- 사용하는 시점에 타입을 원하는 형태로 정의할 수 있음
- 타입 안전(type safe) 효과
- List<E> class / Map<K, V> class

- 제네릭을 사용하지 않는 Pocket 클래스 (Ver. 1) 예제 코드 참고
- 제네릭을 사용한 Pocket 클래스 (Ver. 2) 예제 코드 참고
- 이용 가능한 타입에 제약을 추가한 Pocket 클래스 (Ver. 3)
- class Pocket<E: Book> {...}

#### - Advanced
- 읽기 전용 (Covariance (공변성))
- class Pocket<out T> // Kotlin
- List<? extends T> // Java

- 쓰기 전용 (Contravariance (반공변성))
- class Pocket<out T> // Kotlin
- List<? super T> // Java

- 둘 다 됨 (Invariance (무변성))
- class Pocket<T> // Kotlin, Java

#### - 결론
1. 기본적으로 그냥 일반 제네릭 사용
- class Box<T>
2. 읽기 전용이 필요할 때 out
- List는 내부적으로 out T로 되어있음
- val numbers: List<Number> = listOf<Int>(1, 2, 3)

3. in 은 거의 사용하지 않음
- a. Kotlin 표준 라이브러리 개발
- b. 앱 개발에 불필요   
   
#### - 열거형 (enum)
- 정해 둔 값만 넣어둘 수 있는 타입 (ppt 참고)
- enum 클래스는 when 과 조합으로 모든 처리를 강제할 수 있음


## 💻 예제 코드
- [제네릭 & 열거형 수업](../../src/main/kotlin/day10/Generic.kt)
- [제네릭 & 열거형 연습문제](../../src/main/kotlin/day10/StrongBox.kt)
- [제네릭 & 열거형 테스트](../../src/test/kotlin/day10/StrongBoxTest.kt)


```