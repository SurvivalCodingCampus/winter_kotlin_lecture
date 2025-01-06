import kotlinx.coroutines.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Movie(
    val title: String,
    val director: String,
    val year: Int,
)

suspend fun getMovieInfo(): Movie {
    delay(1000)
    val jsonData = """{"title": "Star Wars", "director": "George Lucas", "year": 1977}"""

    val result = Json.decodeFromString<Movie>(jsonData)

    return result
}


fun pracNum1() = runBlocking {
    println("Main starts on: ${Thread.currentThread().name}")

    val result1 = async(Dispatchers.Default) {
        println("Task 1 runs on: ${Thread.currentThread().name}")
        delay(1000)
        "Result 1"
    }

    val result2 = async(Dispatchers.IO) {
        println("Task 2 runs on: ${Thread.currentThread().name}")
        delay(1000)
        "Result 2"
    }

    println("Awaiting results...")
    println("${result1.await()} and ${result2.await()}")

    println("Main ends on: ${Thread.currentThread().name}")
    val movieData = Movie(title = "영화", director = "너", year = 123)

}


fun main(): Unit = runBlocking {


    speakingBirdLangauage()
    println(getMovieInfo().director)
}


enum class Birds {
    BIRD1 {
        override val voice: String = "꾸우!"
        override val delay: Long = 1000
    },
    BIRD2 {
        override val voice: String = "까앆!"
        override val delay: Long = 2000

    },
    BIRD3 {
        override val voice: String = "짹짹"
        override val delay: Long = 3000

    };

    abstract val voice: String
    abstract val delay: Long

    fun speaking() = println(voice)
}


fun speakingBirdLangauage() = runBlocking {
    var sharedValue = 0

    val groupOfBirds: List<suspend () -> Unit> = listOf(
        ::bird1,
        ::bird2,
        ::bird3
    )

    // 시간 카운트 coroutine
    launch {
        while (true) {
            delay(Birds.BIRD1.delay)
            println(sharedValue)
            ++sharedValue

            if (sharedValue > 4) {
                groupOfBirds.forEach { action ->
                    action.invoke()
                }
            }
        }
    }

    // List로 비동기 함수 launch
    groupOfBirds.forEach { action ->
        val job = launch {
            action()
        }

        if (sharedValue > 10) {
            println("list ${sharedValue}")
            job.cancel()
            groupOfBirds.toMutableList().clear()
        }
    }
}


suspend fun bird1() {
    while (true) {
        println("꾸우!")
        delay(Birds.BIRD1.delay)
    }
}

suspend fun bird2() {
    while (true) {
        println("까악")
        delay(Birds.BIRD2.delay)
    }
}


suspend fun bird3() {
    while (true) {
        println("짹짹")
        delay(Birds.BIRD3.delay)
    }
}

