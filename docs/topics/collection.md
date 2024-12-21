### 일일 학습 기록 (상세)
```markdown
# 2024-12-20

## 📚 오늘 배운 내용
- 컬렉션(collection)의 개념과 사용법

### 정리
- 캡슐화의 개요
- 캡슐화를 하여 멤버나 클래스로의 접근을 제어할 수 있음
- 특히, 필드에 “현실세계에서 불가능한 값"이 들어가지 않도록 제어

- 멤버에 대한 접근 지정
- private 멤버는, 동일 파일내에서만 접근 가능
- public 멤버는, 모든 클래스에서 접근 가능

- 클래스에 대한 접근 지정
- 함수, 변수와 동일한 규칙

### 전체
- 데이터 구조에 따른 대표적인 컬렉션 (자료구조)
- List : 순서대로 쌓여있는 구조 (아이템의 중복 허용)
- Map : 키(key)와 값(value)의 쌍으로 저장 (키의 중복 불가)
- Set : 순서가 없는 집합 (중복 불가)
  
- 자바의 배열과 ArrayList 비교
- 크기 지정 필요 / 추가,제거시 크기 커지거나 감소
- 자바에서는 컬렉션에서 기본형 취급 불가\
- 타입 클래스로 지정

- List 문법
- 1번
  val 리스트명 = mutableListsOf<타입>( 무언가 )
- 2번
  val 리스트명 = mutableListsOf<타입>()
  리스트명.add(무언가)
- listOf() : 수정 불가 리스트
- mutableListOf() : 수정 가능 리스트
- Array 도 있으나 가급적 List 사용함
  
- List 의 탐색 방법
- for (무언가 in 무언가들) { println(무언가) }
- 무언가들.forEach { println(it) }
- 무언가들.forEach { 무언가 ->
        println(무언가)
  }
- 무언가들.forEach(::println)


- Set : 중복 값을 허용하지 않는 집합
- getter 는 제공하지 않기 때문에 반복이 필요하면 
  iterator()를 사용하거나 forEach()를 사용
- List 의 contains 보다 압도적으로 빠름
- val lottoSet = setOf(1, 2, 3, 4)
  println(lottoSet.contains(1)) //true
  println(lottoSet.contains(5)) //false

- Iterator : List 나 Set 은 요소를 탐색할 수 있는 iterator 를 제공한다
- 사용법은 List, Set 똑같다
- val lottoSet = setOf(1, 2, 3, 4)
  val iterator = lottoSet.iterator()
  while (iterator.hasNext()) {
        println(iterator.next())
  }
  
  
- Map : 키(key)의 쌍으로 이루어진 요소를 담는 자료구조
- 키의 중복은 허용되지 않음, Map 은 순서를 보장하지 않는다
- val gildong = mapOf(
      "name" to "홍길동",
      "id" to 0,
      "age" to 20,
  )
- Map 애 저장된 값을 하나씩 얻기
- gildong.entries.forEach {
      println(it.keu)
      println(it.value)
  }
  
  
- 컬렉션의 응용
- 컬렉션 안에 컬렉션, Map 과 List 의 조합
- val sample1: Map<String, List<String>>
  val sample2: List<List<Hero>>
  
- 요소의 참조에 대해
- val hero = Hero(name = "홍길동", hp = 100)
  val heroes: List<Hero> = listOf(hero)
  hero.name = "한석봉"
  println(heroes[0].name) // ? => 결과: 한석봉
- 이유 : 위에 코드에서 인스턴스는 하나이기 때문이다

- 컬렉션 선택
- key, value 쌍 : Map
- 중복 가능 : List
- 중복 불가 : Set
- 순서 중요 : List
- 순서 안 중요 : Set
- 검색 속도 중요 : Set

## 💻 예제 코드
- [컬렉션 문법](../../src/main/kotlin/day5/CollectionMain.kt)
- [컬렉션 연습문제](../../src/main/kotlin/day5/Person.kt)
- [컬렉션 연습문제](../../src/test/kotlin/day5/PersonKtTest.kt)

```