package org.example.day11

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File


class Company {

    companion object {
        const val FILE_NAME = "company.txt"
        val file = File(FILE_NAME)

        fun saveDepartmentData(department: Department) {
            val json = Json.encodeToString(department)
            try {
                file.writeText(json)
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }

        fun clearData() {
            try {
                file.delete()
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }
}