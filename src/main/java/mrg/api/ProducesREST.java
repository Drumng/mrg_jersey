package mrg.api;

import org.jetbrains.annotations.NotNull;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.time.Instant;
import java.util.Date;

@Path("/produces")
public final class ProducesREST {
    @GET
    @Produces("text/html; qs=0.1")
    public String get() {
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
