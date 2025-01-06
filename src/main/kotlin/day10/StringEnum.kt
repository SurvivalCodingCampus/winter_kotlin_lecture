package day10

import java.awt.Rectangle

fun main() {
    // String 인스턴스 비교
    val str1 = "hello"
    val str2 = "hello"       // string은 불변객체이고, 메모리를 재활용 한다
    println(str1 === str2)   // true.    문자열 리터럴은 String Pool이라는 공간에 저장되고, 같은 값의 문자열 리터럴은 같은 객체를 참조하도록 최적화되어 있다.

    val str3 = String("hello".toCharArray())    // "hello" 문자열을 char 배열로 변환한 후 다시 String 객체로 생성하여 str3에 할당.
    println(str1 === str3)    //false.     이 경우는 새로운 String 객체가 생성되므로 str1과는 다른 객체를 참조하게 된다.

    val str4 = "hel" + "lo"
    println(str1 === str4)     //true

    val str5 = "hel" + getLo()
    println(str1 === str5)      //false.   getlo() 생성 시기 다르기 때문에
    println("--------------------------")

    val greeting = "Hello"
    println(greeting.replace("H", "J"))   // Jello.  "H"를 "J"로 변경한 새로운 문자열을 생성
    println(greeting)   // Hello.   문자열의 불변성 때문에 한번 생성된 문자열은 변경될 수 없다. 원본 유지.

    val newGreeting = greeting.replace("H", "J")
    println(newGreeting) // Jello
    println("--------------------------")

    val box = Rectangle(5, 10, 60, 40)
    println(box.x)                       // 5
    println(box.width)                   // 60

    box.translate(25, 40)
    println(box.x)                      // 30  (= 5 + 25)
    println(box.y)                      // 50  (= 10 + 40)
    println("--------------------------")

    var greeting1 = "Hello, World!"
    var greeting2 = greeting1
    greeting2.uppercase()
    var greeting3 = greeting2.uppercase()
    println(greeting1)  // Hello, World!
    println(greeting2)  // Hello, World!
    println(greeting3)  // HELLO, WORLD!

    var luckyNumber1 = 13
    var luckyNumber2 = luckyNumber1   // 값 타입(value type) 변수는 여기서 값이 복사되기 때문에 서로 다른 메모리 공간에 저장된 별개의 값을 갖게 된다. 즉, 각각 독립적인 변수.
                                           // (참조 타입 변수는 객체를 가리키는 주소를 저장하며, 두 개의 변수가 같은 객체를 가리킬 수 있다. 이 경우 한 변수를 통해 객체를 변경하면 다른 변수에서도 변경된 내용이 반영된다)
    luckyNumber2 = 12
    println(luckyNumber1)   // 13
    println(luckyNumber2)   // 12
}

fun getLo() = "lo"


// i 번째 글자가 모음인지 알려주는 isVowel() 함수 완성하기
// 모음은 a, e, i, o, u
class Word(val word: String) {

    fun isVowel(i: Int): Boolean {
        if (i !in word.indices) throw IndexOutOfBoundsException()
        return word[i].lowercase() in "aeiou"
    }

    // i 번째 글자가 자음인지 알려주는 isConsonant() 함수 완성하기
    fun isConsonant(i: Int): Boolean = !isVowel(i)


//    fun isConsonant(i: Int): Boolean {
//        return if (i !in word.indices) false else !isVowel(i)
//    }
}

/*
* require와 throw를 사용할 때의 차이 : 예외를 던지는 대상이 다르다
* require는 함수 내부에서 조건이 false일 때 IllegalArgumentException을 던진다.
* 주로 매개변수나 입력 값을 검증하는 데 사용된다.
*
* throw는 직접 예외를 던지는데, 예외 타입을 직접 지정할 수 있다.
*
* */
