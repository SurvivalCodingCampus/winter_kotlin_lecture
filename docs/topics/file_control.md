### 일일 학습 기록 (상세)
```markdown
# 2024-12-31

## 📚 오늘 배운 내용
- 파일 조작

### 정리

### 전체
#### - 파일 조작의 기본 순서
1. 파일을 연다
2. 파일을 읽거나 쓴다
3. 파일을 닫는다

#### - File 쓰기
- // 파일 지정
  val file = File("경로")
  // 내용 쓰기
  file.writeText("Hello, world!")
- 경로에 파일이 없으면 생성함
- writeText() 는 set이기 때문에 떺어씌움
- 이어서 추가 할거면 appendText()

  
#### - File 읽기
- // 파일 지정
  val file = File("경로")
  // 내용 읽기
  file.readText()
  println(text)
- 경로에 파일이 없으면 터짐

#### - File 제거
- // 파일 지정
  val file = File("경로")
  // 파일 삭제
  file.delete()
    

## 💻 예제 코드
- [파일 조작 연습문제](../../src/main/kotlin/day11/FileOperations.kt)
- [파일 조작 연습문제](../../src/main/kotlin/day11/DefaultFileOperations.kt)
- [파일 조작 연습문제](../../src/test/kotlin/day11/DefaultFileOperationsTest.kt)
- [여러가지 데이터 형식 연습문제](../../src/main/kotlin/day11/Employee.kt)
- [여러가지 데이터 형식 연습문제](../../src/main/kotlin/day11/Department.kt)
- [여러가지 데이터 형식 연습문제](../../src/test/kotlin/day11/SerializationPracticeKtTest.kt)


```