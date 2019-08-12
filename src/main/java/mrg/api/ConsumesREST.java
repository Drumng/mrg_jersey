package mrg.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/consumes")
public final class ConsumesREST {
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public String get(@Nullable String message) {
        return content(message);
    }

    private @NotNull String content(@Nullable String message) {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head><title>Example</title></head>" +
                "<body><h1>" + message + "</h1></body>" +
                "</html>";
    }
}
