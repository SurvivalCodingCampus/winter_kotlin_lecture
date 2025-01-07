package org.example.day14

import org.example.day14.data.repository.StockDataSourceImpl

fun main() {
    StockDataSourceImpl().getStockListings().forEach {
        println(it)
    }
}