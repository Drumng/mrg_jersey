package mrg.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public final class MapExampleDeserializer extends StdDeserializer<MapExample> {
    protected MapExampleDeserializer() {
        super(MapExample.class);
    }

    @Override
    public MapExample deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final MapExample mapExample = new MapExample();
        return mapExample;
    }
}
