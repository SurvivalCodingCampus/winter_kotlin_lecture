package org.hyunjung.day15.user.datasource

import org.hyunjung.day15.user.model.User
import org.hyunjung.day15.util.Constants
import org.hyunjung.day15.util.JsonParser
import org.hyunjung.day15.util.NetworkUtils

class UserDataSourceImpl : UserDataSource {

    override suspend fun getUsers(): List<User> {
        val url = "${Constants.BASE_URL}/users"
        return NetworkUtils.executeRequest(url) { response ->
            JsonParser.parseJson(response)
        }
    }
}