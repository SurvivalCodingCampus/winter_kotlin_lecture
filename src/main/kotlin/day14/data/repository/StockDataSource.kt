package org.example.day14.data.repository

import org.example.day14.data.model.StockListing

interface StockDataSource {
    fun getStockListings(): List<StockListing>
}