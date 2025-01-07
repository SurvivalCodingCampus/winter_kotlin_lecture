package org.example.day15.repository_exam.data_source

import kotlinx.serialization.json.Json
import org.example.day15.repository_exam.model.User
import java.io.File

class MockUserDatasourceImpl : UserDatasource {
    private val filePath = "users.txt"
    private val file = File(filePath)

    override fun getUser(id: Int): User? {
        TODO("Not yet implemented")
    }

    override fun saveUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun getAllUsers(): List<User> {
        return Json.decodeFromString<List<User>>(file.readText())
    }
}