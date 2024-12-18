## Kotlin Variable Type

- `var` - Mutable - 변수
- `val` - Immutable - final 변수

## Kotlin 기본 타입

1. `Byte` 1Byte 정수
2. `Short` 2Byte 정수
3. **`Int`** 4Byte 정수
4. `Long` 8Byte 정수
5. `Float` 4Byte 부동소수점
6. `Double` 8Byte 부동소수점
7. `Char` 2Byte Unicode
8. `Boolean` T/F

### Number

연산 가능한 모든 타입(6개)은 부모로 `Number`클래스를 갖는다.

- `.javaClass`는 어느 클래스에서 생성된 인스턴스인지 클래스를 반환함.

### 값 할당

Kotlin은 다양한 방법으로 기본타입에 값 할당 방법을 제공한다.

ex) 유용한 twoMillion 표현 방식 `2_000_000`

### Boolean

전위연산자(예시 `+ab`)가 메모리 효율이 더 좋다. 스택. pop.

a + b는 중위

| not | ! |
| --- | --- |
| 논리합 | || |
| 논리곱 | && |

### Char

싱글 따옴표 `‘ '` 로 감싸서 표현

```kotlin
 val charRange: CharRange = 'a ' .. ' z '
 // a to z

val char = Char('a') // 모든 타입은 클래스
val char = 'a' //자주 쓰는 기본 타입은 할당하여 생성 가능
// char.code 유니코드 값 반환
```

### Unicode

`아스키코드` : 1byte로 표현 (EUC-KR)

`유니코드` : 전세계언어를 국제적으로 표시할 수 있는 표준코드

`UTF-8` 유니코드로 정의된 것을 어떻게 컴퓨터에 저장 되는지 정의한 것. 한글은 3Byte

### Bitwise

비트연산은 잘 쓸 일 없다. 알아만 두기.

| **or** |  |
| --- | --- |
| **and** |  |
| **xor** |  |
| inv |  |
| shl |  |
| shr |  |
| ushr |  |

### 산술 할당 연산자

이것만 알아두기

a + b

a - b

a * b

a / b

a % b

### 단항, 증감 연산자

이것만 알아두기

!a(Boolean)

++a

- - a

```kotlin
var a = 5

a++ = 5

++a = 6
// 이 둘의 차이 알아두기
```

### Kotlin 비교, 동등 Operators

Int는 기본적으로 Comparable을 가짐. Comparable은 두개를 비교할 때 쓰는 인터페이스

**정렬할 때** 많이 쓴다. 단순 비교 때는 쓰지마라. ( 객체들의 모임을 관리하는 Collection(set, map…)에서 쓴다.)

단순 문자열 비교할때는 == 을 쓰자.

```kotlin
val a = "abc"
val b = "abc"
val c = String("abc")
if(a==b) // 값 비교 - 참 // String의 equals 메소드를 호출. 그 문자열 클래스에서 생성(or할당)된 문자열들을 실질적으로 대소문자 같은지 비교.
if(a===b) // 객체 참조값 비교 - 참 // 할당 - 상수영역 HashCode를 비교
if(a===b) // 객체 참조값 비교 - 거짓 //생성 HashCode를 비교
// Heap 메모리에 상수값 영역이 있다. 할당하면 "abc"는 상수영역을 참조
// 생성하면 상수영역이 아닌 메모리영역을 참조

var s = "abc" + 1 // s = "abc1"

var s = "" // 공백도 객체다.
for (a .. z) {
	s += char // 문자열을 이런식으로 concat하면...
}

"" a
a
b
ab
c
abc
// garbage collecting ... 쓸데없이 객체들이 많이 만들어진다.
// concat때 + 연산 쓰지 말아라.
// StringBuffer(쓰레드 동기화 되어있음)나 StringBuilder(권장)를 쓴다. 

val buf = StringBuffer("abc")

c
b
a

buf.append("d")

d
c
b
a

// 비권장하는 + 연산 concat
s = "abc"
s += "d"
abc d abcd
// abc와 d는 아무 쓸데 없는 데이터가 됨. 참조되고 있지 않으니까. 메모리 낭비.

//반면, concat메소드를 사용하면 내부적으로 스프링버퍼 만들어냄.
```

### Kotlin in 연산자

if, when, loop, range, generic에서 사용

a in b

a !in b

## Kotlin Expression & Statement(중요)

### Kotlin 표현식& 문장

- if, when, try는 문장이 아니라 표현식이다.

expression과 statement를 구분 지을 줄 알아야한다.

expression(표현식) : 단일값을 리턴하는 코딩표현

sum = 21 + 27

      표현식(식은 문장의 한 부분)

전체적인것은 문장(statement)

try catch도 표현식이다(line이 여러 줄이더라도, 그 전체가 식이 될 수 있다)

람다함수에서 많이 쓰는 방식이다(전체가 식이 될 수 있음. 단일 값이나 단일 객체를 리턴하므로)

else if 쓸 일이 있으면 **when문을 써라**. 훨씬 빠르다.

### Kotlin Range

3가지 종류의 Range 타입

1. Char `‘A’..‘Z’`
2. Int `1..45`
3. Long

### Kotlin when Expression

- 다른 언어의 switch문보다 유연성이 좋음
- when은 표현식이다
- const(글로벌 상수 선언 키워드. `val타입만` 가능. 반드시 초기화 되어야) : `상수`선언, `기본타입`과 `String`만 할당 가능

```kotlin
//System.’in’ 코틀린에 in이 키워드로 있기 때문에 ‘’으로 감싸준 것임
when은 분기가 되기 때문에 위에서부터 차례로 비교하는게 아님
문자열을 switch/case문으로 쓰는 언어들도 거의 없다.
```

when 옆에 인자값을 주지 않고도 코딩 가능. 하지만 분기마다 반복해줘야함.

### when의 다양한 사용법

```kotlin
val account = Account(…)

//어떤 클래스에서 파생된 인스턴스냐… 
if(account is Account) //참

if(account is String) // 거짓
```

## Kotlin loop

### for문

```kotlin
for(item in 1..100) { // step 안 적으면 1씩 증가
...
}

for(item in startValue until endValue step 2){
...
}

for(item in startValue..endValue step 2) {
...
}

for (odd in startValue downTo 1 step 2) {
...
}
```

- 함수형 프로그래밍

```kotlin
//나중에 배운다
```

`CallChain 프로그래밍` 비동기로 프로그래밍하면 Rx프로그래밍이 된다. 리액티브 프로그래밍.

### Straring

Kotlin에서 프로그래밍시 중첩for문 잘 안쓴다.

콜체인 방식으로 List나 map 활용하여 별찍기도 나중에 연습해보기

## Kotlin Loop Jump

### break, continue

- Kotlin Jump방법

    1) return

    2) break

    3) continue

- Kotlin Label
- 라벨명@ / @라벨명

ex) return@paycheck 34567 = 34567을 paycheck함수에 넘겨라

## Kotlin 가변인자

### vararg & spread operator(*)

vararg는 인자가 여러개일때 파라미터의 마지막에 반드시 선언 `fun name(val:String, **vararg** nums:Int)`

실제로 잘 안 쓴다. 알아두고 읽을 수 있기만 해라. 왜? 가변인자로 받는 라이브러리들이 있다. 라이브러리에 값 넣을때 스프레드 넣어야 하는 경우 있다.

---


```kotlin
fun generateLottoNumber(num:Int) {
    val range = IntRange(1, 50)  // 로또번호는 1~50까지
    var lottoSet = mutableSetOf<Int>()

    while(lottoSet.size != num) {  // 로또셋 사이즈가 입력한 수가 될 때까지 반복
        lottoSet.add(range.random())  // 랜덤숫자를 중복 안 되게 생성
    }
    println(lottoSet.sorted())  // 정렬하여 출력
}

fun main() {
    generateLottoNumber(7)
}
```

---

## 참고자료

- 코틀린 Edu Course

  https://plugins.jetbrains.com/plugin/17654-atomickotlin

- 책 아토믹 코틀린

  https://product.kyobobook.co.kr/detail/S000201206714