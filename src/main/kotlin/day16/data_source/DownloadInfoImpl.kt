package org.example.day16.data_source

import DownloadInfo
import ImageDataSource

interface IDownloadInfo {
    suspend fun getDownloadInfo(imageDataSource: ImageDataSource): DownloadInfo
}

//class DownloadInfoImpl : IDownloadInfo {
//    override suspend fun getDownloadInfo(imageDataSource: ImageDataSource): DownloadInfo {
//
//
//
//    }
//
//}