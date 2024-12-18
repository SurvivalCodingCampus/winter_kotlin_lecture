import org.example.day03.Cleric

fun main() {

    val hero2 = Cleric("둘", hp=3, mp=5)


    val hero =  Cleric("하나")

    hero.showingStatus()

    hero.selfAid()

    hero.showingStatus()

    val recoveredMp = hero.pray(15)
    println("실제로 회복된 MP의 양 : $recoveredMp")

    hero.showingStatus()

}
