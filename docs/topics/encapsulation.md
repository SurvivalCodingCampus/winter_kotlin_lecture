### 일일 학습 기록 (상세)
```markdown
# 2024-12-20

## 📚 오늘 배운 내용
- 캡슐화(encapsulation)의 개념과 사용법

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
- 현실세계를 객체 지향 프로그램으로 개발
- 하지만 이 과정에서 누군가 객체의 속성이나 기능에 문제를 일으킬 수 있다
- 그러한 일을 방지하기 위해 객체를 캡슐화할 필요가 있다
  
- private / public
- 외부에서 
- 접근 불가 / 접근 가능

- getter / setter
- 메소드를 경유한 필드 조작이을 가능하게 해줌
- getter : 읽기 전용 프로퍼티를 구현할 때 사용
- setter : 쓰기 전용 프로퍼티를 구현할 때 사용
- getter 추가 방법이 다양함 (예제 코드 참고)

- 장점
- Read Only, Write Only 필드의 실현
- 필드의 이름 등, 클래스의 내부 설계를 자유롭게 변경 가능
- 필드로의 엑세스를 검사 가능
- val 은 getter 를 기본적으로 내장
- var 는 getter 와 setter 를 내장
- 생성자에 var, val 가 없으면 getter, setter 가 없는 것으로 간주함

- setter 에서 값의 타당성을 검사할 수 있음
- if, require 사용해서 예외 처리하거나 변경 가능
- backing field 는 프로퍼티의 값을 저장하기 위한 실제 필드. field 로 접근 가능
- (예제 코드 참고)



## 💻 예제 코드
- [getter 추가 방법](../../src/main/kotlin/day3/Hero.kt)
- [setter 로 값의 타당성 검사1](../../src/main/kotlin/day5/Wizard.kt)
- [setter 로 값의 타당성 검사2](../../src/main/kotlin/day5/Wand.kt)

```