package org.example.day14

import org.example.day14.data.mock.MockStockDataSourceImpl

fun main() {
    MockStockDataSourceImpl().getStockListings().forEach {
        println(it)
    }
}