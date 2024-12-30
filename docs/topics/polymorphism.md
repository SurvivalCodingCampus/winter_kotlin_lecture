### 일일 학습 기록 (상세)
```markdown
# 2024-12-26

## 📚 오늘 배운 내용
- 다형성(polymorphism)의 개념과 사용법

### 정리
#### - 인스턴스를 애매하게 퉁치기
- 상속에 의한 is-a 관계가 성립한다면, 인스턴스를 부모 클래스 타입의 변수에 대입할 수 있다
- 부모 클래스 타입 변수에 대입하는 것으로, 퉁 칠 수 있다

#### - **상자의 타입**과 **내용의 타입**의 역할
- 어떤 멤버를 이용할 수 있는가는 상자의 타입이 결정한다
- 멤버가 어떻게 움직이는지는 내용의 타입이 결정한다

#### - 취급 변경
- as 키워드를 사용하여 타입 캐스팅을 수행한다
- is 키워드를 사용하여 타입을 검사할 수 있다

#### - 다형성
- 같은 부모를 가지는 다른 인스턴스를 동일시하여, 부모 클래스 타입에 담을 수 있다
- 마찬가지로, 부모 클래스 타입의 인수나 리턴 값을 이용하여, 다른 클래스를 모아서 처리 가능
- 동일시 취급 해도, 각각의 인스턴스는 각 클래스의 정의를 따르고 다른 동작을 한다


### 전체
#### - 다형성 (polymorphism)
- 어떤 것을 이렇게도 불 수 잇고, 저렇게도 볼 수 있는 것
- 예 : 핸들이 있고, 오른 페달이 엑셀, 왼쪽이 브레이크인 것 = 차, 그랜저, 버스 ...
- **세부적인 부분 부분은 다르지만, 어쨌든 대충 보면 그냥 차다**
  
- **공통 메소드를 통합**
- house.draw()
- dog.draw()
- car.draw()

- 인터페이스 정의
- interface Drawable {
    fun draw()  
  }
  
- 같은 인터페이스를 구현한 Class를 Interface로 선언이 가능하다
- val elements: List<Drawable> = mutableListOf<Drawable>().apply {
    add(Dog(name = "멍멍이, age = 3))
    add(House(address = "서울시 강남구"))
    add(Tree(height = 5.0))
  }

#### - Polymorphism (다형성)  
- val d: Drawable = elements[i] // 실제 타입은 런타임에 결정됨
- d.draw()  // 실제 구현체의 draw() 메서드가 호출됨

- when 식으로 타입 체크 가능
- when(d) {
    is Rectangle -> println("사각형이 선택됨")
    is House -> println("집이 선택됨")
    is Dog -> println("강아지가 선택됨")
  }
- d.draw()  // 다형성 : 실제 타입의 draw() 메소드 호출
  
#### - 다형성을 활용하는 방법
- 선언을 상위 개념으로, 인스턴스 생성은 하위 개념으로 한다.
- **추상적인 선언 = 상세 정의의 인스턴스화**
- val character: Character = Hero(name = "홍길동", hp = 100) // OK
- 다형성 실패
- val sword: Sword = Hero(name = "홍길동", hp = 100) // NG
  
#### - 인터페이스를 변수의 타입으로 사용하기
- interface Human {
    /** 말하기 동작을 정의합니다 */
    fun speak()
  }
- val human: Human = Dancer(name = "댄서", hp = 100)
  
#### - 타입 변경 방법 (cast)
- val monster: Monster = Slime("B")
  val slime: Slime = monster as Slime

- 캐스트 실패
- val character: Character = Wizard(name = "해리포터", hp = 10)
  val hero: Hero = character as Hero
  
- 인스턴스의 타입 체크와 smart cast
- val character: Character = Wizard(name = "해리포터", hp = 10)
  if (character is Hero) {
    val hero: Hero = character
  }
  
- 다형성의 메리트를 활용 못 한 코드
- fun main() {  
    val h1 = Hero("수퍼맨", 100)
    val h2 = Hero("배트맨", 200)
    val h3 = Wizard("해리포터", 50)
    val h4 = Wizard("제이나", 50)
    
    // 모험 개시
    // 여관에 머물기
    h1.hp += 50
    h2.hp += 50
    h3.hp += 50
    h4.hp += 50
  }
- 코드의 중복 제거 (다형성의 메리트 : 동일한 타입으로 취급)
- fun main() {  
    val h1 = Hero("수퍼맨", 100)
    val h2 = Hero("배트맨", 200)
    val h3 = Wizard("해리포터", 50)
    val h4 = Wizard("제이나", 50)

    // 모험 개시
    // 여관에 머물기
    character.forEach { character ->
      character.hp += 50
    }
  }
  
- 메소드 오버로딩
- class Hero(name: String, hp: Int) : Character(name, hp) {
    override fun attack(slime: Slime) {
        println("$name 이 $slime 을 공격했다")
        println("10의 데미지")
        slime.hp -= 10
    }
    
    fun attack(goblin: Goblin) {
        // 고블린 공격
    }
  }
- 이름이 같고 input 형식이 다른 메소드를 추가로 정의할 수 있다  
  
- 다형성을 활용한 Hero  
- class Hero(name: String, hp: Int) : Character(name, hp) {
    override fun attack(monster: Monster) {
        println("$name 이 $monster 을 공격했다")
        println("10의 데미지")
        monster.hp -= 10
    }
  }

- 타입을 하나로 묶고, 잘 동작하게 하기
- fun main() {
    val monsters = mutableListOf<Monster>()
    monster.add(Slime("A"))
    monster.add(Goblin())
  
    monster.forEach { monster ->
        monster.run()
    }
  }

## 💻 예제 코드
- [다형성 수업](../../src/main/kotlin/day08/Monster.kt)
- [다형성 연습문제](../../src/main/kotlin/day08/PolymorphismTest.kt)
- [스타 연습문제 UML](../../src/main/kotlin/day08/StarCraft.puml)

```