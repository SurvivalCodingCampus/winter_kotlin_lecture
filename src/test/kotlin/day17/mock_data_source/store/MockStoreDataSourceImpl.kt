package day17.mock_data_source.store

import kotlinx.serialization.json.Json
import org.example.day17.data_source.store.StoreDataSource
import org.example.day17.dto.store.StoreDTO
import org.example.day17.dto.store.StoreResult

class MockStoreDataSourceImpl : StoreDataSource {
    private val testJson = """
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
              "type": "언노운테스트"
            },
            {
              "addr": "서울특별시 강북구 삼양로 247 3층 (미아동)",
              "code": "12856941",
              "created_at": "2020/07/03 11:00:00",
              "lat": 37.6255182,
              "lng": 127.017747,
              "name": "대지약국",
              "remain_stat": "",
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
              "stock_at": null,
              "type": "01"
            },
            {
              "addr": "서울특별시 강북구 솔샘로 254 2층 2호 (미아동, 삼양아케이트)",
              "code": "11888571",
              "created_at": "2020/07/03 11:00:00",
              "lat": 37.627357,
              "lng": 127.018375,
              "name": "민들레약국",
              "remain_stat": "",
              "stock_at": null,
              "type": "01"
            }
          ]
        }
    """.trimIndent()

    override suspend fun getAllStoreData(): List<StoreDTO> {
        val stores = Json.decodeFromString<StoreResult>(testJson).stores ?: return emptyList()

        return stores
    }
}