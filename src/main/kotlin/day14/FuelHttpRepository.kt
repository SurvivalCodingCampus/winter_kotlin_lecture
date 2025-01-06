package org.example.day14

import fuel.Fuel

interface FuelHttpRepository : HttpRepository {
    val fuelClient: Fuel
        get() = Fuel
}