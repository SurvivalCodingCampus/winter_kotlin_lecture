# Kotlin Study

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
- 회장님 지각 금지