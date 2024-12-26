package day07

interface Thing {
    var weight: Double      // backing field를 가지는 편으로 구성하는 것이 좋겠다.
                            // 예를 들어 각 객체마다 수용해야하는 무게의 조건이 다를 수 있기 때문이다.
}