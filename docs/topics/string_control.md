### 일일 학습 기록 (상세)
```markdown
# 2024-12-30

## 📚 오늘 배운 내용
- 문자열
- 문자열 조작

### 정리

### 전체
#### - 문자열 처리 (결합)
- "Hello" + "Dart"
- => "Hello Dart" 
- 위는 Java에서의 방식
- ${수식}을 활용한 문자열 결합 > Kotlin 방식

- 문자열 처리 (일부 떼어내기)
- val string = "HELLO"
  println(string.substring(0, 2)) => "HELLO" 를 "HE"

- 문자열 처리(일부 치환)
- val string = "HELLO"
  println(string.replace("LL", "XX")) => "HELLO" 를 "HEXXO"

- 문자열 처리(분리)
- val string = "1,2,3"
  val parts = string.split(',')  
  parts.forEach(::println) => "1,2,3" 를 "1" "2" "3"

- 문자열 처리(대소문자 뱐경)
- val string = "HELLO"
  println(string.lowercase()) => "HELLO" 를 "hello"

- 문자열 처리(검색)
- val string = "HELLO"
  println(string.indexOf('E')) => "HELLO" E는 2번째 글자

- 문자열 처리(내용 비교)
- val s1 = "KOTLIN"
  val s2 = "kotlin"
  println(s1 == s2) => false
  println(s1.lowercase() == s2.lowercase()) => true

- 문자열 처리(길이)
- val s1 = "KOTLIN"
  println(s1.length) => 6
  println(s1.isEmpty()) => false

- 문자열 처리(검색)
- val s1 = "Kotlin and Android"
  println(s1.contains("Kotlin")) => true
  println(s1.endsWith("Android")) => true
  println(s1.indexOf("Kotlin")) => 0
  println(s1.lastIndexOf("A")) => 11

- contains() : 포함 관계
- endsWith() : 끝나는 단어가 맞는지
- indexOf() : 단어가 몇 번째에 있는지
- lastIndexOf() : 뒤에서 몇 번째에 단어가 있는지

- 문자열 처리(변환)
- val s1 = "Kotlin and Android"
  println(s1.lowercase()) => 소문자로
  println(s1.uppercase()) => 대문자로
  println(s1.trim()) => 좌우 공백 제거
  println(s1.replace("and", "or")) => 교체
  
#### - 문자열 결합 방법
1) + 연산
2) String interpolation
3) StringBuilder
4) StringBuffer
  
- StringBuffer  
- append() 메서드로 결합한 결과를 내부 메모리(버퍼)에 담아 두고 toString()으로 결과를 얻음
- val sb = StringBuilder("Kotlin")
  sb.append(" and ").
        .append("Android")
  println(sb.toString())

- + 연산자가 느린 이유
- String 인스턴스는 불변 객체 (immutable)
- +를 사용하면 새로운 인스턴스를 생성하기 떄문에 느리다

- String 인스턴스 비교
- 스트링은 한번 사용했던 것을 재사용하는 공간이 따로 존재한다

- val str1 = "hello"
  val str2 = "hello"
  //1번
  println(str1 === str2) // true
  
  //2번
  val str3 = String("hello".toCharArray())
  println(str1 === str3) // false
- 물론 2번처럼 어거지로 String 인스턴스 생성은 가능하다

  //3번
  val str4 = "hel" + "lo"
  println(str1 === str4) // true
- 코틀린에서 (문자열 + 문자열)은 디컴파일시 자바코드에서 애초에 합쳐진 문자열로 처리한다
- 자바에서는 (문자열 + 문자열)은 다른 동작을 한다

  //4번
  val str5 = "hel" + getLo()  // getLo()는 "lo"를 리턴하는 함수
  println(str1 === str5) // false
- 문자열 + 함수/리턴값이 문자열
- 컴파일 타임 + 런 타임
- 즉 위의 3번 경우와 다르게 실행해봐야 알 수 있음 그래서 새로운 String을 생성한다

#### - Accessor, Mutator
- val upppercased = river.toUpperCase() // uppercase()
- toUpperCase() > accessor

- pic.translate(15, 25)
- translate() > mutator

- 예제
- var greeting = "Hello"
  println(greeting.replace("H", "J"))  // "Jello"
  println(greeting)                    // "Hello"

- val box = Rectangle(5, 10, 60, 40)
  println(box.x)        // 5
  println(box.width)    // 60
  box.translate(25, 40) 
  println(box.x)        // 30
  println(box.width)    // 60

- var box1 = Rectangle(5, 10, 60, 90)
  var box2 = box1;
  box1.translate(100, 100);

  box1.x = ? > 105  // 같은 인스턴스 참조중
  box2.x = ? > 105

- String 복사하기
- var greeting1 = “Hello, World!”
  var greeting2 = greeting1
  greeting2.uppercase()

  greeting1 = ? > 그대로
  greeting2 = ? > 그대로
  
- Number 복사
- var luckyNumber1 = 13;
  var luckyNumber2 = luckyNumber1;
  luckyNumber2 = 12;

  luckyNumber1 = ? > 13
  luckyNumber2 = ? > 12


## 💻 예제 코드
- [문자열 조작 수업](../../src/main/kotlin/day10/StringExam.kt)
- [문자열 조작 연습문제](../../src/main/kotlin/day10/Word.kt)
- [문자열 조작 테스트](../../src/test/kotlin/day10/WordTest.kt)


```