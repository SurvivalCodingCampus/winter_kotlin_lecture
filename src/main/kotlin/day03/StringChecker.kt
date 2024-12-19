import kotlin.time.measureTime


fun main() {
    val time = measureTime { {
        var text = ""
        repeat(times = 10000){
            text += "1"
        }
    } }
    println(time)
}