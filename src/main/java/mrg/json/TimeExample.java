package mrg.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.util.StdConverter;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Date;

public final class TimeExample {
    @JsonSerialize(converter = FromTimeExampleConvertor.class)
    @JsonDeserialize(converter = ToTimeExampleConvertor.class)
    @JsonProperty("date")
    private final @NotNull Date date;

    @JsonCreator
    public TimeExample(@NotNull Date date) {
        this.date = date;
    }

    public static final class FromTimeExampleConvertor extends StdConverter<Date, Long> {

        @Override
        public Long convert(Date value) {
            return value.getTime();
        }
    }

    public static final class ToTimeExampleConvertor extends StdConverter<Long, Date> {

        @Override
        public Date convert(Long value) {
            return new Date(value);
        }
    }

    public static void main(String[] args) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final TimeExample timeExample = objectMapper.readValue("12345", TimeExample.class);
        final String s = objectMapper.writeValueAsString(timeExample);
        System.out.println(s);
    }
}
