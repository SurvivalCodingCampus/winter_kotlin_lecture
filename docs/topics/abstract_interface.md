# 추상클래스와 인터페이스

## 추상 클래스

- 상속의 재료로 사용되는 클래스
- 상세부분이 미정이된 클래스
- 추상 클래스는 인스턴스화 할 수 없다
- 오버라이드의 미 구현의 걱정이 없다(강제성)
- open 키워드 없이 사용한다

## 추상 클래스와 추상 메소드

```kotlin
abstract class Character(
  var name: String,
  var hp: Int,
) {
    fun run() = println("$name 이 도망갔다")
    
    // 추상 메서드
    abstract fun attack(slime: Slime)
    
    
   val character = Character(name = "홍길동" , hp = 100) // 에러발생 인스턴스화 금지
```

## 인터페이스

- 모든 메소드는 추상 메소드 여야 한다
- 필드를 가지지 않는다
- 복수의 인터페이스를 부모로 두는 다중상속 효과가 가능

```kotlin

// 추상메서드만 가지는 추상클래스 == 인터페이스 
interface Human() {
    fun speak()
}

// 인터페이스 상속 
interface Fly {
    fun fly()
}

class Bird : Fly {
    override fun fly() {
        println("날기")
    }
}

// 클래스 + 인터페이스 상속 
abstract class Animal {
    abstract fun talk()
}

interface Fly {
    fun fly()
}

class Bird : Animal(), Fly {
    override fun talk() {
        println("짹짹")
    }

    override fun fly() {

    }
}
```
