# 상속

**1. 기본 상속 규칙**

- **클래스는 기본적으로** final
- 다중 상속은 클래스가 아닌 인터페이스로 구현

코틀린에서 모든 클래스는 기본적으로 상속이 불가능합니다. 상속을 허용하려면 open 키워드를 사용해야 합니다.

```kotlin
open class Wizard {
    fun heal() {
        println("힐을 시전했습니다.")
    }
}

class GreatWizard : Wizard() {
    fun superHeal() {
        println("슈퍼 힐을 시전했습니다.")
    }
}
```

**2. 메서드 및 프로퍼티 오버라이드**

- open **키워드**: 부모 클래스에서 메서드나 프로퍼티를 오버라이드하려면 open으로 선언해야 합니다.
- override **키워드**: 자식 클래스에서 반드시 override 키워드를 사용해야 합니다.

```kotlin
open class Wizard {
   open fun heal() {
        println("힐을 시전했습니다.")
    }
}

class GreatWizard : Wizard() {
   override fun heal() {
        println("슈퍼 힐을 시전했습니다.")
    }
}
```

**3. 상속 관련 키워드 정리**

- open: 클래스 또는 메서드/프로퍼티가 상속 및 오버라이드 가능하도록 설정.
- final: 클래스 또는 메서드/프로퍼티가 상속 및 오버라이드 불가능하도록 설정. (기본값)
- abstract: 추상 클래스 또는 추상 메서드를 정의하며 구현은 자식 클래스에서 수행.
- override: 부모의 메서드/프로퍼티를 자식 클래스에서 재정의할 때 사용.
- super: 부모 클래스의 메서드나 생성자를 호출할 때 사용.
