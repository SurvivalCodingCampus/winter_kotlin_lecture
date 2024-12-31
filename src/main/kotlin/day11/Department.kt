package org.example.day11

import kotlinx.serialization.Serializable

@Serializable
data class Department(var name: String, var leader: Employee)