package mrg.api;

import org.jetbrains.annotations.NotNull;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.Instant;
import java.util.Date;

@Path("/time")
public final class PathREST {

    @GET
    public @NotNull String get() {
        return content();
    }

    private @NotNull String content() {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head><title>Example</title></head>" +
                "<body><h1>" + "Current time " + Date.from(Instant.now()) + "</h1></body>" +
                "</html>";
    }
}
