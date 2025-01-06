package day14

import kotlinx.datetime.LocalDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

//symbol,name,exchange,assetType,ipoDate,delistingDate,status
//A,Agilent Technologies Inc,NYSE,Stock,1999-11-18,null,Active
//AA,Alcoa Corp,NYSE,Stock,2016-10-18,null,Active
class StockListingSerializer : KSerializer<StockListing> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("day14.StockListing", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): StockListing {
        val strings = decoder.decodeString().split(',')
        return StockListing(
            symbol = strings[0],
            name = strings[1],
            exchange = strings[2],
            assetType = strings[3],
            ipoDate = LocalDate.parse(strings[4]),
            delistingDate = strings[5].let { if (it == "null") null else LocalDate.parse(it) },
            status = strings[6],
        )

    }

    override fun serialize(encoder: Encoder, value: StockListing) {
        val strings = Array<String>(7) {
            when (it) {
                0 -> value.symbol
                1 -> value.name
                2 -> value.exchange
                3 -> value.assetType
                4 -> value.ipoDate.toString()
                5 -> value.delistingDate?.toString() ?: "null"
                6 -> value.status
                else -> {
                    throw SerializationException("shouldn't be able to reach here")
                }
            }
        }
        encoder.encodeString(strings.joinToString(","))
    }
}