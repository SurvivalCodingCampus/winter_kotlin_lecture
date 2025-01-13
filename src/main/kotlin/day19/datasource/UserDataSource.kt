package day19.datasource

import day19.dto.UserQueryParameter
import day19.dto.UserResponse
import java.util.*

interface UserDataSource {
    fun createUser(id: UUID): Result<UserResponse>
    fun getUser(id: UUID): Result<UserResponse>
    fun updateUser(id: UUID, userQueryParameter: UserQueryParameter): Result<UserResponse>
    fun deleteUser(id: UUID): Result<UserResponse>
}