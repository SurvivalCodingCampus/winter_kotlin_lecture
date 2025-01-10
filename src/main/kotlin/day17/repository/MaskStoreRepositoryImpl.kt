package day17.repository

import day17.dataSource.MaskStoreDataSource
import day17.mapper.maskMapper
import day17.model.Pharmacy

class MaskStoreRepositoryImpl(
    private val dataSource: MaskStoreDataSource
) : MaskStoreRepository {

    override suspend fun getValidStore(): List<Pharmacy> {
        val maskStoreDto = dataSource.getStores()
        val store = maskStoreDto.stores ?: return emptyList()

        return store
            .filter { !it.remainStat.isNullOrEmpty() && !it.stockAt.isNullOrEmpty() && !it.createdAt.isNullOrEmpty() }
            .map { maskMapper(it) }  // 필터링 된 데이터를 PharmacyMapper를 통해 도메인 모델인 Pharmacy로 변환
    }
}
