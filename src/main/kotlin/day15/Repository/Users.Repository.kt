package org.example.day15.Repository

import org.example.day15.Interface.UserDataSource
import org.example.day15.Interface.UserRepositoryImpl
import org.example.day15.Model.User
import org.example.day15.Utils.parseJson
import org.example.day15.Utils.readJson


open class UserDataSourceImpl(private val jsonDataSource: String) : UserDataSource, UserRepositoryImpl {
    override var users: List<User>
        get() = parseJson(jsonDataSource)
        set(value) {}

    override suspend fun getUsers(): List<User> {
        return users
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return users.sortedBy { user -> -user.id }.slice(0..9)
    }
}


const val userDataSource = "./src/main/kotlin/day15/RawData/users.json"

class UserRepository : UserRepositoryImpl, UserDataSourceImpl(readJson(userDataSource)) {
}

