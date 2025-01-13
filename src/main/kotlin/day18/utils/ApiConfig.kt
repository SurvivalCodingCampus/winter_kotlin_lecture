package day18.utils

import com.typesafe.config.ConfigFactory
import kotlinx.serialization.Serializable

@Serializable
data class ApiConfig(
    val pixabay: PixabayConfig
) {
    @Serializable
    data class PixabayConfig(
        val apiKey: String
    )

    companion object {
        fun load(): String {
            return try {
                val config = ConfigFactory.load() // ConfigFactory를 통해 설정 파일을 읽음
                if (!config.hasPath("pixabay")) {
                    throw IllegalStateException("Pixabay 설정을 찾을 수 없습니다.")
                }
                val pixabayConfig = config.getConfig("pixabay")// pixabay 블록을 읽음
                if (!pixabayConfig.hasPath("apiKey")) {
                    throw IllegalStateException("Pixabay API키가 설정되지 않았습니다.")
                }
                return pixabayConfig.getString("apiKey") // apiKey 값을 읽어 반환
            } catch (e: Exception) {
                throw IllegalStateException("설정을 로드하는 중 오류가 발생했습니다. ${e.message}")
            }
        }
    }

}
