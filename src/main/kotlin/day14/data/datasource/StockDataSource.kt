package org.example.day14.data.datasource

import org.example.day14.data.model.StockListing

interface StockDataSource {
    fun getStockListings(): List<StockListing>
}