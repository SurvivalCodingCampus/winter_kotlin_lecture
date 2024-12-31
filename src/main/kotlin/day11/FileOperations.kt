package day11

import java.io.File
import java.io.FileNotFoundException
import java.io.OutputStream
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

    fun copyOverStream(fileToCopy: File, destination: OutputStream) {
        val fileInputStream = fileToCopy.inputStream()
        val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
        var bytesRead = fileInputStream.read(buffer)
        while (bytesRead != -1) { // EOF Check
            destination.write(buffer, 0, bytesRead)
            destination.flush()
            bytesRead = fileInputStream.read(buffer)
        }

        fileInputStream.close()
        destination.close()
    }
}