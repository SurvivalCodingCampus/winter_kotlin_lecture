package day17.mock

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import org.example.day17.datasource.MASK_STORES_URL

val maskStoreMockEngine = MockEngine { request ->
    when (request.url.toString()) {
        MASK_STORES_URL -> {
            respond(
                content = ByteReadChannel(maskStoresRepositoryTestData),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        else -> {
            respondError(HttpStatusCode.NotFound)
        }
    }
}

val maskStoresRepositoryTestData = """
    {
      "count": 222,
      "stores": [
        {
          "addr": "서울특별시 강북구 솔매로 38 (미아동)",
          "code": "11817488",
          "created_at": "2020/07/03 11:00:00",
          "lat": 37.6254369,
          "lng": 127.0164096,
          "name": "승약국",
          "remain_stat": "plenty",
          "stock_at": "2020/07/02 18:05:00",
          "type": "01"
        },
        {
          "addr": "서울특별시 강북구 삼양로 247 3층 (미아동)",
          "code": "12856941",
          "created_at": "2020/07/03 11:00:00",
          "lat": 37.6255182,
          "lng": 127.017747,
          "name": "대지약국",
          "remain_stat": "plenty",
          "stock_at": "2020/07/03 10:45:00",
          "type": "01"
        },
        {
          "addr": "서울특별시 강북구 삼양로 255 (미아동)",
          "code": "11819723",
          "created_at": "2020/07/03 11:00:00",
          "lat": 37.6261612,
          "lng": 127.0180494,
          "name": "청구약국",
          "remain_stat": "plenty",
          "stock_at": "2020/07/03 10:40:00",
          "type": "01"
        }
      ]
    }

""".trimIndent()