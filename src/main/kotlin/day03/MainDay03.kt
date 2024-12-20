import org.example.day03.Hero
import org.example.day03.Sword
import org.example.day03.Wand

fun main() {

    val person = Person("hello", birthYear = 1937, age=38)

    val wand = Wand(name="한", magicDamage = 0.4)

    val hero4 = Hero(name = "검사", sword = Sword(name = "불꽃검", damage = 30))
//    val hero5 = Hero()
    val hero6 = Hero("아서스")

}
