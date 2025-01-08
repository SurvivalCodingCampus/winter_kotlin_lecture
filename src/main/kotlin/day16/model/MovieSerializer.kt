package day16.model

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.*

object MovieSerializer : JsonTransformingSerializer<List<Movie>>(ListSerializer(Movie.serializer())) {
    override fun transformDeserialize(element: JsonElement): JsonElement =
        element.jsonObject["results"]?.jsonArray ?: JsonArray(emptyList())
}
