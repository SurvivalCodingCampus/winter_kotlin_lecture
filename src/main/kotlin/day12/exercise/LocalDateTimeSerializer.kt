package day12.exercise

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDateTime

/*
* KSerializer Interface 구현체
*
* descriptor: 어떤 직렬화/ 역직렬화 함수를 가지고 있는지 설명
*
* deserialize(): Decoder 인스턴스를 받아 decode된 값을 역직렬화
*
* serialize() 함수를 Encoder 인스턴스와 직렬화할 값을 받아 Encoder에 encode
* */
object LocalDateTimeSerializer: KSerializer<LocalDateTime> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("java.time.LocalDateTime", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): LocalDateTime {
        return LocalDateTime.parse(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        encoder.encodeString(value.toString())
    }
}