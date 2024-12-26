package day07


/*
* 자산인지 아닌지 따지지 말고, 형태가 있는것 (Thing)이면 무게가 있다.
* 그래서, double형 무게를 얻을 수 있도록 getter/setter를 가지는 인터페이스 Thing을 만드시오
* */
interface Thing {
    // 무게
    var weight: Double
}