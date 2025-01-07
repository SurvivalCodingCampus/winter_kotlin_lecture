package org.example.day15.Repository

import org.example.day15.Interface.UserDataSource
import org.example.day15.Interface.UserRepositoryImpl
import org.example.day15.Model.User
import org.example.day15.Utils.parseJson


open class UserDataSourceImpl(private val jsonFilePath: String) : UserDataSource, UserRepositoryImpl {
    override var users: List<User>
        get() = parseJson(jsonFilePath)
        set(value) {}

    override suspend fun getUsers(): List<User> {
        if (users.isEmpty()) emptyList<String?>()
        return users
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        if (users.isEmpty()) emptyList<String?>()
        return users.sortedBy { user -> -user.id }.slice(0..9)
    }

}


const val userDataSource = "./src/main/kotlin/day15/RawData/users.json"

class UserRepository : UserRepositoryImpl, UserDataSourceImpl(userDataSource) {
}

