sealed class RResult<out D, out E> {
    data class Success<out D>(val data: D) : RResult<D, Nothing>()
    data class Error<out E>(val error: E) : RResult<Nothing, E>()
}