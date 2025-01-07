# Kotlin Study

## 📝 학습 기록

- [2024-12-16](src/docs/daily/2024-12-16.md) - Git, GitHub 기초
- [2024-12-17](src/docs/daily/2024-12-17.md) - Kotlin 기초 문법
- [2024-12-18](src/docs/daily/2024-12-18.md) - Kotlin 인스턴스와 클래스
- [2024-12-19](src/docs/daily/2024-12-19.md) - Kotlin 클래스 생성자와 companion object
- [2024-12-20](src/docs/daily/2024-12-20.md) - Kotlin 캡슐화와 컬렉션
- [2024-12-27](src/docs/daily/2024-12-27.md) - 인스턴스 기본 조작
- [2024-12-30](src/docs/daily/2024-12-30.md) - 제네릭, 열거형, 문자열 조작
- [2024-12-31](src/docs/daily/2024-12-31.md) - 예외, 파일 조작, 여러가지 데이터 형식
- [2025-01-02](src/docs/daily/2025-01-02.md) - 디버깅, 람다식과 함수
- [2025-01-03](src/docs/daily/2025-01-03.md) - 비동기 프로그래밍, 코루틴
- [2025-01-07](src/docs/daily/2025-01-07.md) - Test 이론, Model Class, Repository 개념

## 💻 작성 코드

- Day 2
    - [Basic.kt](src/main/kotlin/day02/Basic.kt) - Kotlin Basic
    - [Basic.java](src/main/kotlin/day02/Basic.java) - Java Basic
- Day 3
    - [Hero.kt](src/main/kotlin/day03/Hero.kt) - 용사(Hero) Class
    - [Slime.kt](src/main/kotlin/day03/Slime.kt) - 슬라임(Slime) Class
    - [Cleric.kt](src/main/kotlin/day03/Cleric.kt) - 성직자(Cleric) Class
    - [ClericTest.kt](src/test/kotlin/day03/ClericTest.kt) - 성직자(Cleric) Test Code
- Day 4
    - [Cleric.kt](src/main/kotlin/day04/Cleric.kt) - 성직자(Cleric) Class
    - [ClericTest.kt](src/test/kotlin/day04/ClericTest.kt) - 성직자(Cleric) Test Code
- Day 5
    - [Wand.kt](src/main/kotlin/day05/Wand.kt) - 지팡이(Wand) Class
    - [Wizard.kt](src/main/kotlin/day05/Wizard.kt) - 마법사(Wizard) Class
    - [Person.kt](src/main/kotlin/day05/Person.kt) - Person Class
    - [WandTest.kt](src/test/kotlin/day05/WandTest.kt) - 지팡이(Wand) Test Code
    - [WizardTest.kt](src/test/kotlin/day05/WizardTest.kt) - 마법사(Wizard) Test Code
    - [PersonTest.kt](src/test/kotlin/day05/PersonTest.kt) - Person Test Code
- Day 9
    - [Book.kt](src/main/kotlin/day09/Book.kt) - 책(Book) 클래스
    - [BookTest.kt](src/test/kotlin/day09/BookTest.kt) - 책(Book) Test Code
- Day 10
    - [StrongBox.kt](src/main/kotlin/day10/StrongBox.kt) - StrongBox Class
    - [Word.kt](src/main/kotlin/day10/Word.kt) - Word Class
    - [StrongBoxTest.kt](src/test/kotlin/day10/StrongBoxTest.kt) - StrongBox Test Code
    - [WordTest.kt](src/test/kotlin/day10/WordTest.kt) - Word Test Code
- Day 11
    - [RuntimeError.kt](src/main/kotlin/day11/RuntimeError.kt) - Use `try-catch()`
    - [FileOperations.kt](src/main/kotlin/day11/FileOperations.kt) - FileOperations Interface
    - [DefaultFileOperations.kt](src/main/kotlin/day11/DefaultFileOperations.kt) - DefaultFileOperations Class
    - [Serialization.kt](src/main/kotlin/day11/Serialization.kt) - Serialization Example Code
    - [Company.kt](src/main/kotlin/day11/Company.kt) - Employee, Department Class
    - [DefaultFileOperationsTest.kt](src/test/kotlin/day11/DefaultFileOperationsTest.kt) - DefaultFileOperations Test Code
- Day 12
    - [JsonToList.kt](src/main/kotlin/day12/JsonToList.kt) - JsonToList Code
    - [JsonToListSolution.md](src/main/kotlin/day12/JsonToListSolution.md) - JsonToList Solution
    - [Transactions.kt](src/main/kotlin/day12/Transactions.kt) - Transactions Query
- Day 13
    - [Async.kt](src/main/kotlin/day13/Async.kt) - Async Example Code
    - [Movie.kt](src/main/kotlin/day13/Movie.kt) - Movie Code
    - [BirdSounds.kt](src/main/kotlin/day13/BirdSounds.kt) - BirdSounds Code
    - [TimedBirdSounds.kt](src/main/kotlin/day13/TimedBirdSounds.kt) - TimedBirdSounds Code
    - [MovieKtTest.kt](src/test/kotlin/day13/MovieKtTest.kt) - Movie Test Code
- Day 15
    - [Main.kt](src/main/kotlin/day15/post/Main.kt) - Post Main Code
    - [Constants.kt](src/main/kotlin/day15/util/Constants.kt) - Constants
    - [JsonParser.kt](src/main/kotlin/day15/util/JsonParser.kt) - Json Parser
    - [NetworkUtils.kt](src/main/kotlin/day15/util/NetworkUtils.kt) - NetworkUtils

## 📚 주제별 정리

- [Git](src/docs/topics/git.md)
- **Kotlin**
    - [Class](src/docs/topics/class.md)
    - [Collection](src/docs/topics/kotlin-collection.md)
    - [Coroutines](src/docs/topics/coroutines.md)
    - [Equals](src/docs/topics/equals.md)
    - [Random](src/docs/topics/random.md)
- **Java**
    - [ArrayList](src/docs/topics/java-array-list.md)
- [TDD](src/docs/topics/tdd.md)

## 🔍 참고 자료

- [Kotlin 공식 문서](https://kotlinlang.org/docs/home.html)
- [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- [Kotlin in Action](https://www.manning.com/books/kotlin-in-action)
- [코틀린 코루틴의 정석](http://www.acornpub.co.kr/book/kotlin-coroutines)

---

## 📝 과제 제출 방법

1. 본인의 브랜치 생성
    - 브랜치명: `student/01-홍길동`
    - 메인 브랜치에서 새로운 브랜치 생성

2. 과제 수행
    - `src/main/kotlin/날짜별 폴더`에 소스코드 작성
    - `docs/daily`에 TIL(Today I Learned) 작성
    - 커밋 메시지는 명확하게 작성

3. PR(Pull Request) 생성
    - 제목: `[2024-01-15] 홍길동 - 과제 제출`
    - 내용: PR 템플릿에 따라 작성
    - 리뷰어 지정 필수

## 📋 리뷰어 지정 규칙

1. 선생님 필수 리뷰어 지정
2. 매주 그룹 지정하여 그룹간에 리뷰
    - 그룹 매칭 결과는 매주 월요일 공지
    - 한 주간 같은 그룹과 상호 리뷰 진행

## 📁 폴더 구조

```
kotlin-study/
├── src/
│   └── main/
│       └── kotlin/
│           ├── day1/
│           │   ├── Person.kt        // 클래스 작성
│           │   └── Solution.kt      // 실습 문제 풀이
│           └── day2/
│               └── Variable.kt      // 변수 관련 실습
│
├── docs/
│   ├── daily/                 // 일일 학습 기록
│   │   ├── 2024-01-15.md
│   │   └── 2024-01-16.md
│   │
│   └── topics/               // 주제별 심화 학습 기록
│       ├── generics.md
│       └── lambda.md
│
├── build.gradle.kts
└── README.md
```

## ✍️ TIL 작성 가이드

### 일일 학습 기록 (daily)

```markdown
# 2024-01-15

## 📚 오늘 배운 내용

- 제네릭의 in, out 개념
- 반공변성과 공변성의 차이점

## 💻 예제 코드

<!-- 실습한 코드나 예제를 추가 -->

## 🔍 참고 자료

- [제네릭 상세 정리](../topics/generics.md)

## ❓ 궁금한 점

- 반공변성은 언제 사용하면 좋을까요?
```

### 개인 학습 현황 기록

```markdown
# Kotlin Study

## 📝 학습 기록

- [2024-01-15](docs/daily/2024-01-15.md) - 변수와 함수
- [2024-01-16](docs/daily/2024-01-16.md) - 변수의 타입과 범위

## 💻 작성 코드

- Day 1
    - [Person.kt](src/main/kotlin/day1/Person.kt) - 클래스 실습
    - [Solution.kt](src/main/kotlin/day1/Solution.kt) - 과제 풀이
- Day 2
    - [Variable.kt](src/main/kotlin/day2/Variable.kt) - 변수 실습

## 📚 주제별 정리

- [제네릭](docs/topics/generics.md)
- [람다](docs/topics/lambda.md)

## 🔍 참고 자료

- [Kotlin 공식 문서](https://kotlinlang.org/docs/home.html)
- [코틀린 스타일 가이드](https://kotlinlang.org/docs/coding-conventions.html)
```

## ⭐️ 참고사항

- 모든 코드는 코틀린 스타일 가이드를 따라 작성할 것
- 궁금한 점이 있다면 PR에 코멘트로 남길 것
- 매일 학습 내용을 TIL로 정리할 것