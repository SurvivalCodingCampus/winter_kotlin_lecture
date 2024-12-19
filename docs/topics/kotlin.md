### 일일 학습 기록 (상세)
```markdown
# 2024-12-17

## 📚 오늘 배운 내용
- Kotlin은 JVM 기반 언어이다
- 자바의 단점을 많이 보완한 언어
- Kotlin의 장점
- Null을 사용가능여부를 상수/변수 선언에서 정함
- 타입뒤에 ?붙여서 null 사용가능여부를 정함 (Int? , String?)
  
- 확장 함수를 통해서 새로운 기능을 쉽게 추가 가능함

- 문장 마지막에 ";"이 필요 없음
  
- 상수 / 변수 선언은 val, var로 선언 (타입은 생략가능)
- 코틀린에서는 상수(val)를 주로 사용

- if문 문법은 예제 코드 참고 
- 코틀린은 삼항 연산이 불가

- for문 문법은 예제 코드 참고

- 리스트 선언시 변경 불가 (자바처럼 추가 제거 불가)

- 함수 문법은 "fun 함수명(변수 or 상수: 타입, ...): 반환타입 { ..."
- 반환타입으로 Unit사용 (자바에서 void와 같은 역할)
- 짧은 함수 작성도 가능 (예제 코드 참고)



## 💻 예제 코드
- val a = 10 
- val b = 5
- val name2: String? = null
- val name3: String = ""

- val c = if (a > b) a else b

- val items : List<String> = listOf("apple", "banana")
- for (item in items){ 
    println(item)
  }

- fun plus5(x: Int): Int {  //"{" 앞에서 alt + enter로 아래 처럼 한줄로 가능
      return x + 5
  }
- fun plus5(x: Int): Int = x + 5
  
- fun printSum(a: Int, b: Int): Unit { ... }


# 2024-12-18

## 📚 오늘 배운 내용
- const 상수 와 그냥 상수의 차이
  컴파일타임에 메모리에 올라가는 상수와 런타임에 실행되면서 메모리에 올라가는 상수

- class Hero (name: String, hp: Int) {}
  () 괄호가 자바의 생성자 역할

- 인풋에 대해서 아웃풋이 항상 같으면 함수 
  다를 수도 있으면 메소드

- 필드에서 접근하려면 val, var 사용해야함

- 코틀린은 조건 반복 함수들을 식으로 표현가능

- 코틀린 객체 생성시에 new 사용안함

- 생성자에 초기값 설정해 놓으면 객체생성시에 값지정을 안하면 초기값을 설정

## 💻 예제 코드
```kotlin
class Cleric(
    val name: String,
    var hp: Int = 50,
    val maxHp: Int = 200,
    var mp: Int = 25,
    val maxMp: Int = 100
) {
    fun selfAid() {
        if (mp >= 5) {
        mp -= 5
        hp = maxHp
        }
    }

    fun pray(prayTime: Int = 3): Int {
        val numberRange = (0..2)
        val number = numberRange.random()
        val startMp = mp

        mp += (prayTime + number)

        if (mp > maxMp) mp = maxMp - startMp

        val recoveryMp = mp - startMp

        return recoveryMp
    }
}
```