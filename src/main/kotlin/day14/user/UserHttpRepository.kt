package org.example.day14.user

import org.example.day14.FuelHttpRepository

interface UserHttpRepository : FuelHttpRepository {
    override val baseUrl: String
        get() = "https://jsonplaceholder.typicode.com/users"

    suspend fun getUsers(): List<User>
}