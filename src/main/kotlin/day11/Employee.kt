package org.example.day11

import kotlinx.serialization.Serializable

@Serializable
data class Employee(var name: String, var age: Int)