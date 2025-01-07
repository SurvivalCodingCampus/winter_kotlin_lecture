package day14

import kotlinx.datetime.LocalDate
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.AbstractDecoder
import kotlinx.serialization.encoding.AbstractEncoder
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule

//symbol,name,exchange,assetType,ipoDate,delistingDate,status
//A,Agilent Technologies Inc,NYSE,Stock,1999-11-18,null,Active
//AA,Alcoa Corp,NYSE,Stock,2016-10-18,null,Active
@ExperimentalSerializationApi
object StockListingSerializer {
    class CSVEncoder : AbstractEncoder() {
        var value: String? = null
        override val serializersModule: SerializersModule = EmptySerializersModule()
        override fun encodeValue(value: Any) {
            value as StockListing
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
            this.value = strings.joinToString(",")
        }
    }

    class StockListingDecoder(val record: String) : AbstractDecoder() {
        private var elementIndex = 0
        override val serializersModule = EmptySerializersModule()

        override fun decodeElementIndex(descriptor: SerialDescriptor): Int {
            if (elementIndex == descriptor.elementsCount) return CompositeDecoder.DECODE_DONE
            return elementIndex++
        }

        @Suppress("UNCHECKED_CAST")
        override fun <T> decodeSerializableValue(deserializer: DeserializationStrategy<T>): T {
            val strings = record.split(",")
            return StockListing(
                symbol = strings[0],
                name = strings[1],
                exchange = strings[2],
                assetType = strings[3],
                ipoDate = LocalDate.parse(strings[4]),
                delistingDate = strings[5].let { if (it == "null") null else LocalDate.parse(it) },
                status = strings[6],
            ) as T
        }
    }

    private fun <T> encodeToString(serializer: SerializationStrategy<T>, value: T): String {
        val encoder = CSVEncoder()
        encoder.encodeSerializableValue(serializer, value)
        return encoder.value!!
    }

    fun encodeToString(value: StockListing) = encodeToString(serializer(), value)

    private fun <T> decodeFromString(record: String, deserializer: DeserializationStrategy<T>): T {
        val decoder = StockListingDecoder(record)
        return decoder.decodeSerializableValue(deserializer)
    }

    fun decodeFromString(record: String): StockListing = decodeFromString(record, serializer())
}
