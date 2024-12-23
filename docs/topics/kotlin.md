## Kotlin

코틀린은 자바의 단점을 보완하고자 나온 언어이다   
변수보단 상수를 쓰는게 실수나 버그를 줄일 수 있다

### Java와 차이점

- Null
    - java : null을 허용한다
    - kotlin
        - null을 허용하지 않는다 -> NullPointException 방지
        - list도 수정 불가
        - nullable type : null이 될 수 있는 타입을 명시적으로 표시 (타입 뒤에 물음표 붙임)

- 문자열 처리
    - java : + 연산 기호 사용
    - kotlin : $로 연결 가능
       ```kotlin
       fun main(){
         var name = "한석봉"
         val fullName = "홍$name"
         println(fullName) // -> 홍한석봉
       }
       ```
- 확장함수 지원 여부
    - kotlin : 기존 클래스에 새로운 메서드 추가하는 것처럼 사용
       ```kotlin
       // 형태 : fun 클래스명.함수명
      
      //String 확장함수
      fun String.addExclamation(): String {
      return this + "!"             //this는 확장 대상 클래스의 인스턴스
      }
  
      fun main() {
      val text = "Hello"
      println(text.addExclamation())  // 출력: Hello!
      }
  
       ```
### 상수
|특징|companion object 사용|클래스 외부 선언|
|------|---|---|
|상수의 연관성|특정 클래스와 연관이 강함|특정 클래스와 연관이 없음|
|접근 방식|객체 지향적|절차 지향적|
|사용 범위|주로 클래스와 밀접하게 연결된 상수|파일 전체에서 사용 가능한 상수|
|코드의 의미 전달|클래스와 관련된 상수임을 명확히 전달|관련성을 암시하지 않음|

### 생성자
```kotlin
class 클래스 이름 constructor(생성자의 매개변수 선언) { }  //constructor는 생략 가능
```
* 생성자의 매개변수 
```kotlin
constructor(name: String, age: Int)
```
-> 객체가 생성될 때 외부에서 전달받는 임시 변수   
이 매개변수는 생성자와 초기화 블록(init)내부에서만 사용할 수 있다   
클래스 내에서 사용하려면 클래스의 프로퍼티로 저장해야 한다

* val로 선언된 프로퍼티
```kotlin
val name: String
val age: Int
```
-> 클래스 내부에서 접근하거나 사용할 수 있는 클래스의 속성   
클래스 전체에서 사용 가능   
생성자 매개변수로 전달받은 값을 저장하거나 init블록 또는 다른 초기화 방법으로 값 설정

* init 블록에서의 초기화
```kotlin
init
{
this.name = name
this.age = age
}
```
-> 생성자 매개변수로 전달받은 값을 클래스 프로퍼티에 할당하거나 초기화 로직 실행   
클래스의 모든 프로퍼티 및 생성자의 매개변수에 접근 가능   


![img.png](img/img.png)
객체 생성 시 생성자의 매개변수 name과 age에 전달된 값이 임시 변수로 생성된다   
init 블록에서 생성자 매개변수를 클래스의 프로퍼티 name과 age에 할당한다

- 위 코드의 간결화
```kotlin
class Person(val name: String, val age: Int)
// 곧바로 클래스의 프로퍼티로 선언하고 초기화
```

