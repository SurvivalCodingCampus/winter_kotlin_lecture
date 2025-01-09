package day17.repository

import day15.common.ResponseResult
import day17.datasource.MaskDataSource
import day17.mapper.mapper
import day17.model.Store
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MaskRepositoryImpl(
    private val maskDataSource: MaskDataSource
) : MaskRepository {
    override suspend fun getUseStoreData(): List<Store> = withContext(Dispatchers.IO) {
        when (val result = maskDataSource.getStore()) {
            is ResponseResult.Success -> {
                result.data.stores?.filter {
                    !it.remainStat.isNullOrBlank() && !it.stockAt.isNullOrBlank() && !it.createdAt.isNullOrBlank()
                }?.map { it.mapper() } ?: emptyList()
            }

            is ResponseResult.Failure -> {
                println("통신 실패")
                emptyList()
            }
        }
    }

}