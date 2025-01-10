package day18.utils

import com.typesafe.config.ConfigFactory
import kotlinx.serialization.Serializable

@Serializable
data class ApiConfig(
    val pixabay: PixabayConfig
) {
    @Serializable
    data class  PixabayConfig(
        val apiKey: String
    )

    companion object {
        fun load():String {
            // application.conf 파일을 읽어오기 위한 설정
            val config = ConfigFactory.load() // ConfigFactory를 통해 설정 파일을 읽음
            val pixabayConfig = config.getConfig("pixabay") // pixabay 블록을 읽음
            return pixabayConfig.getString("apiKey") // apiKey 값을 읽어 반환
        }
    }
}
