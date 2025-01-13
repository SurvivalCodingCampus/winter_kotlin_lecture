import io.github.cdimascio.dotenv.dotenv

val dotenv = dotenv()
val apiKey = dotenv["API_KEY"] ?: throw IllegalStateException("API_KEY 환경변수가 설정되지 않았습니다.")


object Constants {
    const val BASE_URL: String = "https://pixabay.com/api/"
    var KEY: String = apiKey
}


fun extractKey(url: String): String {
    val keyRegex = "key=([^&]+)".toRegex()
    return keyRegex.find(url)?.groupValues?.get(1) ?: ""
}
