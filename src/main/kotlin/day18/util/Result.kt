import day18.util.PhotoError

sealed class ResultPhoto<out D> {
    data class Success<out D>(val data: D) : ResultPhoto<D>()
    data class Error(val error: PhotoError) : ResultPhoto<Nothing>()
}

