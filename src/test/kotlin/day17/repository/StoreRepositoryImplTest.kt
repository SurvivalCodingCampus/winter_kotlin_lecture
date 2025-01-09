package day17.repository

import day17.data_source.StoreDataSource
import day17.dto.StoreDto
import day17.dto.StoreResponse
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class StoreRepositoryImplTest {
    private val mockStoreDataSource = object  : StoreDataSource {
        override suspend fun getStoreInfoList(): List<StoreDto> {
            val storeResponse = Json.decodeFromString<StoreResponse>(fakeStoreJsonString)
            return storeResponse.stores!!
        }
    }

    @Test
    fun `Store데이터 null 빼고 잘 가져옴 확인`() = runTest {
        val repository = StoreRepositoryImpl(mockStoreDataSource)
        val stores = repository.getStoreInfoList()

        assertEquals("승약국", stores[0].name)
        assertEquals(2, stores.size)
    }

    private val fakeStoreJsonString = """
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
              "created_at": "",
              "lat": 37.6255182,
              "lng": 127.017747,
              "name": "대지약국",
              "remain_stat": "plenty",
              "stock_at": "2020/07/03 10:45:00",
              "type": "01"
            },
                {
              "addr": "서울특별시 노원구 동일로243길 33 1층 (상계동)",
              "code": "11894377",
              "created_at": "2020/03/15 23:55:00",
              "lat": 37.6784694,
              "lng": 127.053145,
              "name": "건강샘온누리약국",
              "remain_stat": "",
              "stock_at": "2020/03/15 09:34:00",
              "type": "01"
            },
            {
              "addr": "서울특별시 노원구 동일로 1669 (상계동)",
              "code": "12820296",
              "created_at": "2020/07/03 11:00:00",
              "lat": 37.6774491,
              "lng": 127.0549313,
              "name": "수락프라자약국",
              "remain_stat": "plenty",
              "stock_at": "",
              "type": "01"
            },
            {
              "addr": "서울특별시 노원구 동일로245가길 41 109호 (상계동, 은빛2단지아파트)",
              "code": "12862436",
              "created_at": "2020/07/03 11:00:00",
              "lat": 37.6800016,
              "lng": 127.0538723,
              "name": "은빛약국",
              "remain_stat": "some",
              "stock_at": "2020/07/03 09:14:00",
              "type": "01"
            }
          ]
        }
    """.trimIndent()
}

