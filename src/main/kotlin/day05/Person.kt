import java.time.LocalDate

class Person(
    val name: String,
    val birthYear: Int = 0,
    age: Int = 0
) {
    var age: Int =
        if (birthYear == 0) {
            age
        } else {
            LocalDate.now().year - birthYear
        }
        private set
}