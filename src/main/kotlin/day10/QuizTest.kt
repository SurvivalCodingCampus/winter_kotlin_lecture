package day10

data class Person(val name: String, val age: Int)    // data class를 사용하면 getter, setter, toString(), hashCode(), copy(), equals() 등의 메소드를 수동으로 구현할 필요가 없다.
val p1 = Person("Kim", 20)
val p2 = Person("Kim", 20)

class Book(val title: String, val price: Int) : Comparable<Book> {  // 다른 Book 객체와 비교할 수 있도록 Comparable 인터페이스를 상속
    override fun compareTo(other: Book): Int {      // compareTo 메소드 오버라이딩: 두 Book 객체를 비교하는 메소드. 이 메소드의 반환값에 따라 정렬 순서가 결정된다. price가 작은 순으로 정렬
        return this.price - other.price
    }
}

data class Address(var city: String)
data class User(var name: String, val address: Address)

data class User2(val name: String)

data class Student(val name: String, val score: Int)

class Student2(val name: String, val age: Int) // 일반 클래스
data class DataStudent(val name: String, val age: Int) // data 클래스

data class Point(val x: Int)

data class Team(val name: String, val members: MutableList<String>)

data class Hero2(val name: String, val hp: Int)

class NomalPerson(val name: String, val age: Int) // 일반 클래스
data class DataPerson(val name: String, val age: Int) // 데이터 클래스

fun main() {
    println(p1 == p2) // true
                      // 왜냐하면 data class는 equals() 메소드가 자동으로 오버랑디이 돼서, 모든 속성 (name과 age)값이 동일하면 두 인스턴스를 같은 것으로 판단한다 : 객체의 동등성 비교
    println("--------------------------------")

    val books = listOf(
        Book("B", 1000),
        Book("A", 2000),
        Book("C", 1500)
    )
    println(books.sorted().first().title)   // B
    println("--------------------------------")

    val user1 = User("John", Address("Seoul"))
    val user2 = user1.copy()    // user1 객체를 깊은 복사하여 user2에 할당
                                      // data class는 copy() 함수를 자동으로 제공하여 객체를 쉽게 복사할 수 있다
                                      // 그런데 address 속성은 참조 타입이므로, user1과 user2는 동일한 Address 객체를 참조하게 된다
    user2.address.city = "Busan"      // 따라서 user1의 address.city 값도 Busan으로 변경된다
    user2.name = "James"
    println(user1.address.city)       // Busan
    println(user1.name)               // John.  user1과 user2는 서로 다른 객체이므로, user2의 name을 변경해도 user1의 name은 영향을 받지 않는다
    println(user2.name)               // James

    /*
    얕은 복사 (Shallow Copy): 객체를 복사할 때, 참조 타입의 속성은 원본 객체와 동일한 객체를 참조한다.
    즉, 새로운 객체가 생성되지만, 참조 타입의 속성은 기존 객체를 가리키므로, 원본 객체의 변경이 복사된 객체에도 영향을 미친다.

    깊은 복사 (Deep Copy): 객체를 복사할 때, 참조 타입의 속성까지 완전히 새로운 객체로 복사한다.
    즉, 새로운 객체와 참조 타입의 속성 모두 독립적인 객체가 되므로, 원본 객체의 변경이 복사된 객체에 영향을 미치지 않는다.
    * */

    // 만약 user2의 address를 완전히 독립적인 객체로 만들고 싶다면, address 속성을 복사할 때 copy() 함수를 한 번 더 사용하면 된다.
    // 이렇게 하면 user1과 user2는 서로 다른 Address 객체를 참조하게 되므로, user2의 address를 변경해도 user1의 address에는 영향을 미치지 않는다.
    val user3 = user1.copy(address = user1.address.copy())
    user3.address.city = "America"
    println(user1.address.city)       // Busan
    println("--------------------------------")

    val students = listOf(
        Student("Kim", 80),
        Student("Lee", 90),
        Student("Park", 80),
    )

    val sorted = students.sortedWith(
        compareBy<Student> { it.score }.thenBy { it.name }      // compareBy : 하나 이상의 속성을 기준으로 정렬하는 데 사용. 각 속성에 대한 비교 결과를 반환하여 정렬 순서를 결정한다.
                                                                // thenBy : 앞선 비교 결과가 같은 경우, 추가적인 비교 기준을 제공한다
    )
    println(sorted.first().name)    // Kim

    // 만약 내림차순으로 결과를 보고 싶다면
    val sorted2 = students.sortedWith(
        compareByDescending<Student> { it.score }.thenBy { it.name }
    )
    println(sorted2.first().name)

    val sorted3 = students.sortedWith(
        compareBy<Student> { -it.score }.thenBy { it.name }
    )
    println(sorted3.first().name)
    println("--------------------------------")

    val map = hashMapOf(User2("Kim") to "value")    // User("Kim") 객체를 키로, "value"를 값으로 저장
    println(map[User2("Kim")])  // value
    println("--------------------------------")

    println(Student2("Kim", 20).toString())       // day10.Student2@42110406 해시코드 출력.     toString() 메소드를 오버라이드하지 않으면, 객체의 메모리 주소가 출력된다
    println(DataStudent("Kim", 20).toString())    // DataStudent(name=Kim, age=20) 내용 출력.  toString() 메소드는 객체의 모든 프로퍼티를 문자열 형태로 보기 좋게 출력해준다
    println("--------------------------------")

    val p1 = Point(1)
    val p2 = Point(1)
    println(p1 === p2)  // false.  속성 값이 같더라도 서로 다른 객체
                        // === 연산자는 두 변수가 같은 객체를 참조하는지 확인한다. 즉, 메모리상의 같은 위치를 가리키는지 확인
    println(p1 == p2)   // true.   == 연산자는 두 변수가 같은 값을 가지는지 확인한다.
    println("--------------------------------")

    val team1 = Team("A팀", mutableListOf("Kim"))
    val team2 = team1.copy()    // team1을 얕은 복사
    team2.members.add("Lee")
    println(team1.members.size)     // 2.    team1과 team2는 같은 members 리스트를 참조하므로, team1의 멤버 목록에도 "Lee"가 추가된다
    println("--------------------------------")

    val heroes = mutableListOf<Hero2>()     // List는 중복을 허용하므로 h1과 h2가 같은 값을 가지더라도 모두 추가될 수 있다.
    val h1 = Hero2("슈퍼맨", 100)
    val h2 = Hero2("슈퍼맨", 100)

    heroes.add(h1)
    println(heroes.size) // 1

    heroes.remove(h2)
    println(heroes.size) // 0       -> h1과 같은 객체를 찾아 제거하기 때문에 리스트의 크기는 0이 된다.
                                     // Hero가 일반클래스일 경우엔 동일한 참조를 가진 객체가 리스트에 없으므로 제거에 실패해서 1로 나온다.

    println(h1 == h2)   // true
    println(h1 === h2)  // false

    val heroes2 = mutableSetOf<Hero2>()      //set은 중복을 허용하지 않음
    heroes2.add(h1)
    heroes2.add(h2)
    println(heroes2.size)    // 1           // Hero2가 일반클래스일 경우엔 2로 나옴. 이유는 일반 클래스에서 객체 비교는 참조 비교를 사용하므로 h1과 h2가 다른 객체로 간주돼서 두번 모두 추가되기 때문이다.
    heroes2.remove(h2)
    println(heroes2.size)    // 0

    println(h1 == h2)        // true
    println(h1 === h2)       // false
    println("--------------------------------")


    val person1 = NomalPerson("슈퍼맨", 10)
    val person2 = NomalPerson("슈퍼맨", 10)
    val dataPerson1 = DataPerson("슈퍼맨", 10)
    val dataPerson2 = DataPerson("슈퍼맨", 10)

    println(person1 === person2) // false (다른 객체를 참조)
    println(person1 == person2) // false (equals()를 오버라이드하지 않았으므로 참조 비교)

    println(dataPerson1 === dataPerson2) // false (다른 객체를 참조)
    println(dataPerson1 == dataPerson2) // true (equals()가 자동으로 생성되어 값 비교)
    println("--------------------------------")

}

