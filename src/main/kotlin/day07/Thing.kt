package org.example.day07

interface Thing {
    /// 인터페이스 내부에는 추상 프로퍼티를 선언할 수 있음
    /// var weight => getWeight(), setWeight() 를 생략하고 추상 프로퍼티로 선언
    var weight: Double
}