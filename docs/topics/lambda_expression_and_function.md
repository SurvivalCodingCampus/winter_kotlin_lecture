### 일일 학습 기록 (상세)
```markdown
# 2025-01-02

## 📚 오늘 배운 내용
- 람다식과 함수

### 정리

### 전체
#### - 1급 객체
- 변수에 대입 가능한 객체를 1급 객체 (first class object) 라고 한다
- 대표적인 1급 객체 : 값, 인스턴스, 함수

#### - 함수
- 함수도 1급 객체로 취급 됨
- 입력이 동일할 때 항상 동일한 출력을 한다
- 예: f(x) = 2x + 3

#### - 람다 (lambda)
#### - **람다식 (lambda expression)**
- list.filter { it > 10 }
    
#### - 함수를 값으로 전달하는 예
- 입출력 타입만 같다면 같은 함수로 볼 수 있다
- fun printElement(element: Int) {
    println(element)
  }
  
  fum main() {
    val list = listOf(1, 2, 3)
    list.forEach(::printElement)
  }

#### - 메서드와 함수의 차이
- 메서드는 클래스에 속하고 클래스를 조작하기 위한 일종의 함수
- 메서드는 이름이 있지만, 함수에게 이름은 중요치 않다
- val list = listOf(1, 2, 3)
  list.forEach({ e -> println(e) })
- val list = listOf(1, 2, 3)
  list.forEach { e -> println(e) }
- 완전히 동일한 코드  

#### - **람다식 (lambda expression)**
- 함수 내용을 바로바로 정의해서 사용하고 싶다~!!
- val loudify = { msg: String -> "!!! ${msg.uppercase()} !!!" }
  assert(loudify("hello") == "!!! hello !!!")

#### - Functional interface 또는 Single Abstract Method (SAM) interface
- list.sortedWith(object: Comparator<Int> {
    override fun compare(o1: Int, o2: Int): Int {
        return o1 - o2
    }
  } )
- 함수가 하나만 있는 인터페이스는 람다로 변경 가능
- list.sortedWith { o1, o2 -> o1 - o2 }

#### - 콜백
- 나중에 실행될 코드를 미리 등록해 두는 것
    - 택배 배송 알림
    - 음식점 진동벨
    - 세탁이 완료 알림
    - "일 다 끝나면 전화해줘"
    
- 콜백을 알면 다음 내용을 더 쉽게 이해할 수 있음
1. 비동기 개념
2. 이벤트 처리 방식
3. 함수를 파라미터로 전달하는 개념

#### - 콜백 기초
- 예제 코드 참고 (수업)
- 콜백용 인터페이스, 여러개의 메서드가 있어도 됨
- 콜백 인터페이스를 파라미터로 받고 특정 시점에 메서드를 호출

#### - 함수를 파라미터로 사용하는 콜백
- 예제 코드 참고 (수업)
- 콜백용 인터페이스의 함수가 1개라면 인터페이스 대신 함수로 대체 가능
- 마지막 파라미터가 함수면 () 생략 가능
- 메서드 레퍼런스 기법으로 함수 호출 가능

#### - 콜백을 활용하여 값을 전달하는 예시
- 예제 코드 참고 (수업)
- 활용 패턴
1. 비동기 작업의 결과 처리
2. 진행 상황 모니터링
3. 에러 처리

#### - 콜백에 함수를 활용하면
- 인터페이스 정의 불필요
- 더 간단한 문법
- 더 간단한 문법
- 더 유연한 사용
- **이것이 함수형 프로그래밍의 시작**

#### - **함숳형 프로그래밍**
- Kotlin은 객체지향 프로그래밍(OOP)과 함수형 프로그래밍(FP) 특징을 모두
  제공하는 멀티 패러다임 언어임
- 함수형 프로그래밍은 자료 처리를 수학적 함수의 계산으로 취급하는
  프로그래밍 패러다임이고 가변 데이터를 멀리하는 특징을 가진다 (변수 사용 자제)

#### - 고계 함수
- **함수를 파라미터로 받는 함수**
- filter : 조건 필터링
- map : 변환
- forEach : 전체 빵빵이
- reduce : 하나씩 줄이기
- fold : 하나씩 접기
- any : 있는지 없는지

#### - filter 함수
- 2가지 방법 모두 동일한 결과를 나타냄
1.val items = listOf(1, 2, 3, 4, 5)

  for (item in items) {
    if (item % 2 == 0) {
        println(item)   // 2, 4
    }
}
2.item.filter { it % 2 == 0 }.forEach(::println) // 2, 4
  
#### - map 함수
- 두 방식 모두 동일함
1.val items = listOf(1, 2, 3, 4, 5)
  for (item in items) {
    if (item % 2 == 0) {
        // 숫자 2, 숫자 4
        println("숫자 $item")
    }
  }
2.items.filter { it % 2 == 0 } 
    .map { "숫자 $it" } 
    .forEach( : :println)

#### - toSet()
- 자료구조 Set으로 변환하는 함수
- 중복을 허용하지 않기 때문에 간단히 중복데이터를 제거할 수 있습니다 
1.val items = listOf(1, 2, 2, 3, 3, 4, 5)
  val temp = mutableSetOf<Int>()

  for (item in items) {
    if (item % 2 == 0) {
        temp.add(item)
    }
  }
  val result = temp.toList()
  println(result) // 2, 4
2.val result = items.filter { it % 2 == 0 }.toSet().toList()
  val result = items.filter { it % 2 == 0 }.distinct()

#### - any
- 특정 조건을 충족하는 요소가 있는지를 검사할 때 사용합니다.
1.val items = listOf(1, 2, 2, 3, 3, 4, 5)
  var result = false

  for (item in items) {
    if (item % 2 == 0) {
        result = true
        break
    }
  } 
  println(result)
2.println(items.any { it % 2 == 0 } )

#### - reduce
- 반복 요소를 줄여가면서 결과를 만들 때 사용하는 함수입니다.
1.val items = listOf(1, 2, 3, 4, 5)
  var maxResult = items[ø]
  
  for (item in items) {
    maxResult = max(maxResult, item)
  }
  println(maxResult)
2.println(items.reduce { acc, i -> max(acc, i) }) // 5
  println(items. reduce( : :max))   // 5

#### - 안티패턴 소개
- forEach 에서 중단 시도
- // 1. 잘못된 접근 (forEach에서 break 시도)
  list.forEach { item -> // 나쁜 예시
    if (condition) {
        return@forEach  // break 처럼 사용하려고 시도
    }
    // 처리
  }
// 2. 올바른 접근 방법들:
// A. 전통적인 for 문 사용 (break가 필요한 경우)
  for (item in list) { // 좋은 예시
    if (condition) break
    // 처리
  }

#### - 안티패턴 소개
- map 에서 중단 시도,
- map 에서 예외

- // 1. map 내에서 return 시도
  list.map { item ->
    if (someCondition) {
        return@map null // 의도한 대로 동작하지 않음
    }
  transform(item)
  }
// 2. map 내에서 예외 발생
  list.map { item ->
    if (someCondition) {
        throw Exception("중단!") // 예외를 흐름 제어에 사용
    }
    transform(item)
  }
 
#### - 안티패턴의 조건
1. 함수형 프로그래밍의 의도 위반
2. 코드의 에측 가능성 저하
3. 부작용 (side effect) 발생 가능
4. 가독성 저하
5. 유지보수 어려움
- forEach : 각 요소에 대한 동작 수행
- map : 변환된 새 컬렉션 생성

## 💻 예제 코드
- [람다식과 함수 수업](../../src/main/kotlin/day12/Function.kt)
- [람다식과 함수 연습문제1](../../src/main/kotlin/day12/LambdaPractice.kt)
- [람다식과 함수 연습문제1](../../src/main/kotlin/day12/CollectionChartDataList.kt)
- [람다식과 함수 연습문제1](../../src/main/kotlin/day12/CollectionChartData.kt)
- [람다식과 함수 연습문제1](../../src/main/kotlin/day12/CollectionSalePrice.kt)


```