package mrg.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class MapExample {
    private final @NotNull Map<Integer, Entry> map = new HashMap<>();

    public void put(int id) {
        map.put(id, new Entry(id));
    }

    public @NotNull Collection<Entry> values() {
        return map.values();
    }

    public static final class Entry {
        private final int id;

        public Entry(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public static void main(String[] args) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(MapExample.class, new MapExampleSerializer());
        simpleModule.addDeserializer(MapExample.class, new MapExampleDeserializer());
        objectMapper.registerModule(simpleModule);
        final MapExample value = new MapExample();
        value.put(1);
        value.put(2);
        final String s = objectMapper.writeValueAsString(value);
        final MapExample mapExample = objectMapper.readValue(s, MapExample.class);
    }
}
