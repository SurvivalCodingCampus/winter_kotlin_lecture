package day11

import java.io.FileNotFoundException
import kotlin.io.path.Path

interface FileOperations {
    @Throws(
        FileNotFoundException::class,
        IllegalArgumentException::class
    )
    fun copy(fromPath: String, toPath: String)
}

class DefaultFileOperations : FileOperations {
    override fun copy(fromPath: String, toPath: String) {
        val paths = pathResolver(fromPath, toPath)
        val from = paths.first.toFile()
        val to = paths.second.toFile()

        if (!to.canWrite()) {
            throw IllegalArgumentException()
        }
        to.writeBytes(from.readBytes())
    }

    private fun pathResolver(fromPath: String, toPath: String) = Path(fromPath) to Path(toPath)
}