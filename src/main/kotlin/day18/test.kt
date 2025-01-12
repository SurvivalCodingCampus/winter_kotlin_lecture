package day18

import day18.dto.PhotoDto
import day18.dto.PixabayResponse
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import java.io.File

fun main() = runBlocking {
//    val client = HttpClient(CIO)
//
//    val agenda = File("apikey").readText()
//
//    val data = Json.decodeFromString<PixabayResponse>(client.get("https://pixabay.com/api/?key=48140988-de83779d7ac0c334c1589aa09&q=food&image_type=photo&pretty=true").bodyAsText())
//    //val data2 = Json.decodeFromString<List<PhotoDto>>(data.hits.toString())
//    val tempData = data.hits!!.get(0)!!.tags
//    val stringData = tempData!!.split(",",)
//    val stringData2 = stringData.map {
//        it.trim()
//    }
//
//    println(data.hits!!.get(0)!!.webformatURL)


}