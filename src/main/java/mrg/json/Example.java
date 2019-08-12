package mrg.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Example {
    public final @NotNull String data;
    public final @NotNull List<Integer> values;

    @JsonCreator
    public Example(@JsonProperty("data") @NotNull String data,
                   @JsonProperty("values") @NotNull List<Integer> values) {
        this.data = data;
        this.values = values;
    }

    public static void main(String[] args) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final Example example = objectMapper.readValue(
                "{" +
                        "\"data\": \"something\", " +
                        "\"values\": [5, 4, 3, 2, 1]" +
                        "}", Example.class);
        final String s = objectMapper.writeValueAsString(example);
        System.out.println(s);
    }
}
