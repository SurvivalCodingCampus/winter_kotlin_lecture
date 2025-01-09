package org.hyunjung.day16.image

import kotlinx.coroutines.runBlocking
import org.hyunjung.day16.ApiModule
import org.hyunjung.day16.image.datasource.ImageDataSourceImpl
import org.hyunjung.day16.image.repository.ImageDownloadRepositoryImpl

fun main() = runBlocking {
    val client = ApiModule.create()
    val dataSource = ImageDataSourceImpl(client)
    val repository = ImageDownloadRepositoryImpl(dataSource)

    val imageUrl =
        "https://community-media.linkareer.com/55666?Policy=eyJTdGF0ZW1lbnQiOlt7IlJlc291cmNlIjoiaHR0cHM6Ly9jb21tdW5pdHktbWVkaWEubGlua2FyZWVyLmNvbS8qIiwiQ29uZGl0aW9uIjp7IkRhdGVMZXNzVGhhbiI6eyJBV1M6RXBvY2hUaW1lIjoxNzM5MDE5MjA1fX19XX0_&Key-Pair-Id=K355AZ2AKPMK1Z&Signature=aFx3mSa8KNyZSqPFpP0-c0IKD0JK2bOLOmnObmt1UjIYytsNtBjnmlJFinIll8RWvoGgv3JTdUFIMYYxvf6JGftx3CCsrzd2h0Vo2hLAWswgYQZJManWrLfAJ5vfuDkb1VdlJRSYa0mBbO7CEdNVFczYtBCAdqlWuMd2ccOC6AL220h-Z1j7hqBqD5vc-AcZkHFFy7VcYpXmTRfOes-6ujUMO~EZkIgkmNScAKlZMUAlWjzoDW7PchYD29jk9XNSIS84YWkkvleSy3Ib0vykviD~Zh2m7KCherG2b2NV-f2wktCc9JsWnNaoI1To7VV1CQgdZQmRnaaPZ8x9l~WQnA"

    val savePath = "src/main/kotlin/day16/image/test/download_image.jpg"

    repository.saveImage(imageUrl, savePath)

    client.close()
}