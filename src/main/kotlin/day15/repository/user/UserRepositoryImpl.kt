package day15.repository.user

import day15.common.ResponseResult
import day15.data_source.user.UserDataSource
import day15.model.User

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return when (val result = userDataSource.getUsers()) {
            is ResponseResult.Success -> {
                result.data
            }

            is ResponseResult.Failure -> {
                emptyList()
            }
        }
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return when (val result = userDataSource.getUsers()) {
            is ResponseResult.Success -> {
                result.data.sortedBy { it.name }.take(10)
            }

            is ResponseResult.Failure -> {
                emptyList()
            }
        }
    }
}