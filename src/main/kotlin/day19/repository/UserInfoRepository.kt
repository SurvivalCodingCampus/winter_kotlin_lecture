package day19.repository

import day19.model.User

interface UserInfoRepository {
    fun getUsers(): List<User>
}