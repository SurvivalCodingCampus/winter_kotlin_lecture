# Kotlin

# Kotlin 기본 문법

## 1. 변수와 타입

- **val**: 불변(immutable) 변수 선언
- **var**: 가변(mutable) 변수 선언
- **lateinit:** 초기화 시점을 나중으로 미룰 수 있음 **“**var”로 선언된 가변 변수에만 사용가능
- **lazy:** 변수에 처음 접근하는 순간 한 번만 초기화됨 “val”로 선언된 불변 변수에만 사용 가능

```kotlin
val name: String = "Kotlin"  // 불변
var age: Int = 25           // 가변
var score = 100            // 타입 추론

```

```jsx
class Person {
    lateinit var name: String //초기화 시점을 나중으로 미룰 수 있음.

    fun initializeName() {
        name = "John"
    }

    fun printName() {
        if (::name.isInitialized) { //초기화 여부를 런타임에 확인 가능
            println("Name is $name")
        } else {
            println("Name is not initialized yet")
        }
    }
}

fun main() {
    val person = Person()
    person.printName() // 출력: Name is not initialized yet
    person.initializeName()
    person.printName() // 출력: Name is John
}

val heavyComputation: Int by lazy {
    println("Computing the value...")
    42 // 초기화 작업
}

fun main() {
    println("Before accessing heavyComputation")
    println(heavyComputation) // 출력: Computing the value... 42
    println(heavyComputation) // 출력: 42 (이미 초기화된 값 사용)
}
```

## 2. 기본 데이터 타입

- **Numbers**: Int, Long, Float, Double
- **Boolean**: true/false
- **Char**: 문자
- **String**: 문자열
- **Array**: 배열

## 3. 조건문

```kotlin
// if-else
if (score >= 90) {
    println("A")
} else if (score >= 80) {
    println("B")
} else {
    println("C")
}

// when (switch 대체)
when (score) {
    100 -> println("Perfect")
    in 90..99 -> println("Excellent")
    else -> println("Good")
}
```

## 4. 반복문

```kotlin
// for loop
for (i in 1..5) {
    println(i)
}

// while loop
var i = 0
while (i < 5) {
    println(i)
    i++
}
```

## 5. 함수

```kotlin
// 기본 함수 선언
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 단일 표현식 함수
fun multiply(a: Int, b: Int) = a * b

// 기본값 매개변수
fun greet(name: String = "World") {
    println("Hello, $name!")
}
```

## 6. Null 안전성

- **?**: Nullable 타입 선언
- **?.**: Safe call 연산자
- **!!**: Non-null 단언 연산자
- **?:**: Elvis 연산자

```kotlin
var nullableString: String? = null
val length = nullableString?.length ?: 0
```

## 7. 컬렉션

- **List**: 순서가 있는 데이터 모음
- **Set**: 중복을 허용하지 않는 데이터 모음
- **Map**: 키-값 쌍의 데이터 모음

```kotlin
val numbers = listOf(1, 2, 3)
val fruits = mutableListOf("apple", "banana")
val ages = mapOf("John" to 25, "Jane" to 24)
```

## 8. 클래스와 객체

```kotlin
// 기본 클래스
class Person(val name: String, var age: Int) {
    fun introduce() {
        println("I'm $name, $age years old")
    }
}

// 데이터 클래스
data class User(val name: String, val id: Int)

// 객체 생성
val person = Person("John", 25)
```

## 9. 람다식

```kotlin
val sum = { x: Int, y: Int -> x + y }
val numbers = listOf(1, 2, 3, 4, 5)
numbers.filter { it > 3 }
```

## 10. 확장 함수

```kotlin
fun String.addHello(): String {
    return "Hello $this"
}

val name = "Kotlin"
println(name.addHello()) // 출력: Hello Kotlin
```

# Java와 Kotlin의 주요 차이점

## 1. Null 안전성

- **Java**: Null 참조로 인한 NullPointerException 발생 가능
- **Kotlin**: 타입 시스템에서 null 가능성을 명시적으로 처리 (?. 연산자 등)

## 2. 변수 선언

```kotlin
// Java
String name = "Java";
final String constant = "Constant";

// Kotlin
var name = "Kotlin"    // 가변
val constant = "Constant"    // 불변
```

## 3. 스마트 캐스트

- **Java**: 명시적인 타입 캐스팅 필요
- **Kotlin**: 컴파일러가 자동으로 타입 추론 및 캐스팅

## 4. 데이터 클래스

```kotlin
// Java
public class Person {
    private String name;
    private int age;
    // getter, setter, equals, hashCode, toString 필요

// Kotlin
data class Person(val name: String, val age: Int)
// 자동으로 getter, setter, equals, hashCode, toString 생성
```

## 5. 확장 함수

- **Java**: 상속이나 데코레이터 패턴 사용 필요
- **Kotlin**: 기존 클래스에 새로운 함수를 직접 추가 가능

## 6. 표현식과 문장

- **Java**: if, try 등이 문장(statement)
- **Kotlin**: if, try 등이 표현식(expression)으로 값 반환 가능

## 7. 코루틴 지원

- **Java**: 비동기 처리를 위해 CompletableFuture, Thread 등 사용
- **Kotlin**: 코루틴을 통한 간편한 비동기 프로그래밍 지원

## 8. 프로퍼티

```kotlin
// Java
public class User {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

// Kotlin
class User {
    var name: String // 자동으로 getter/setter 생성
}
```

## 9. 함수형 프로그래밍

- **Java**: Java 8부터 제한적인 함수형 프로그래밍 지원
- **Kotlin**: 처음부터 함수형 프로그래밍을 위한 다양한 기능 제공

## 10. 기타 차이점

- 세미콜론(;) 생략 가능 (Kotlin)
- 기본적으로 모든 클래스가 final (Kotlin)
- 원시 타입과 래퍼 타입의 구분이 없음 (Kotlin)
- 더 간결한 문법과 표현력 (Kotlin)
