### 일일 학습 기록 (상세)
```markdown
# 2024-12-27

## 📚 오늘 배운 내용
- 인스턴스의 기본 조작

### 정리
#### - Object 클래스의 기본 기능
- toString() / equals() / hashCode()

#### - 정렬
- list
- Comparable을 구현한 객체를 가지는 컬렉션 내부를 정렬해 줌

#### - 인스턴스의 복사
- 얕은 복사 : 값을 복사, 인스턴스는 주소만 복사
- 깊은 복사 : 값을 복사, 새로운 인스턴스를 생성하고 값을 복사

#### - data class
- Kotlin 에서는 data class로 정의하면 
- equals()
- hashCode()
- toString()

- 다음 메서드를 추가해 준다. 얕은 복사 기본 지원
- copy()

### 전체
#### - Object 클래스의 기본 기능
- Java에서 모든 클래스는 Object 클래스의 메서드와 프로퍼티를 가지고 있다
- Java에서 Object 타입 변수에는 모든 인스턴스를 대입할 수 있다
- Kotlin 에서는 Any, 하지만 근본은 Object를 따름

- <Object 클래스의 대표 메서드>
- toString() : 문자열 표현을 얻음
- equeals() : 비교 (Kotlin 에서는 == 과 동일함)
- hashCode() : 해시값을 얻음

- **toStirng() 재정의**
- 오버라이드하여 원하는 결과를 얻도록 수정할 수 있음 (예제 코드 참고)

- **equals() 재정의**
- equals() 를 재정의 하여 == 으로 비교시 나만의 동등성 규칙을 정의할 수 있다 (예제 코드 참고)
- List 에서 동등성 비교시 사용됨

- **hashCode() 재정의**
- hashCode() 를 재정의하면 Set, Map 내부에서의 동등성 규칙으로 사용 됨 (예제 코드 참고)

- 클래스 내부의 모든 래퍼런스의 동등함을 비교해야 한다
- 만약 프로퍼티를 추가한다면 추가한 프로퍼티도 equals(), hashCode() 를 작성해 줘야 한다 (예제 코드 참고)

- Set, Map 의 동작 원리
- Set, Map 계열은 요소를 검색할 때 hashCode 를 사용하여 빠르다
- List는 순차검색이라 느림

  1. 모든 객체는 해시값을 가진다
  2. 동일한 객체는 항상 같은 해시값을 가진다
    
- **리스트에서의 요소 정렬**
- List.sorted() 메서드는 Comparable을 구현한 객체를 가지는 컬렉션 내부를 정렬해 줌

- 미리 정렬 규칙을 정하기 위한 Comparable 인터페이스 사용 (예제 코드 참고)
- compareTo()  
- 즉석에서 정렬 규칙을 정하기 위한 Comparator 인터페이스
- compare()
- a 가 b 보다 작으면 음수 (-1)
- 같으면 0
- a 가 b 보다 크면 양수 (+1)

- Comparator 객체를 구현한 예
- val results = heros.sortedWith { a, b -> a.name.compareTo(b.name) }
- val results = heros.sortedWidth( compareBy { it.name })
- val results = heros.sortedBy { it.name }
- 결국 sortedBy() 만 쓰면 됨

- **인스턴스의 복사**
- copy 메서드

- 얕은 복사
- class Address(
    var street: String
  )
  
  class Person(
    val name: String,
    val age: Int,
    val address: Address
  ) {
    fun shallowCopy() = Person(name, age, address) // 주소 객체는 같은 참조
  }
- 레퍼런스 타입을 복사할 때 주소 객체는 같은 참조가 발생함

- 깊은 복사
- class Address(
    var street: String
  ) {
    fun deepCopy() = Address(street)
  }

  class Person(
    val name: String,
    val age: Int,
    val address: Address
  ) {
    fun deepCopy() = Person(name, age, address.deepCopy()) // 주소 객체도 새로 생성
  }
- 레퍼런스 타입을 복사할 때 새로운 객체를 생성해서 값을 복사해 줌

#### - data class
- Kotlin 에서는 data class로 정의하면
- 다음 메서드를 재정의 해 준다  
- equals()
- hashCode()
- toString()

- 다음 메서드를 추가해 준다. 얕은 복사 기본 지원
- copy()
- 깊은 복사는 따로 구현해야 함


## 💻 예제 코드
- [인터페이스 기본 조작 수업](../../src/main/kotlin/day03/Hero.kt)
- [인터페이스 기본 조작 수업](../../src/main/kotlin/day03/Slime.kt)
- [인터페이스 기본 조작 수업](../../src/main/kotlin/day07/Book.kt)
- [인터페이스 기본 조작 수업](../../src/main/kotlin/day09/Instance.kt)
- [인터페이스 기본 조작 수업](../../src/main/kotlin/day09/InstanceJava.java)
- [인터페이스 기본 조작 수업](../../src/main/kotlin/day09/Sort.kt)
- [인터페이스 기본 조작 수업](../../src/main/kotlin/day09/SortJava.java)
- [인터페이스 기본 조작 연습문제](../../src/main/kotlin/day09/Book.kt)


```