package mrg.api;

import mrg.json.Example;
import org.jetbrains.annotations.NotNull;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Arrays;

@Path("/json")
public final class JsonREST {

    @Path("/post")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public @NotNull String post(Example example) throws IOException {
        return "Data - " + example.data + ", values - " + example.values.toString();
    }

    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public @NotNull Response get() {
        return Response.ok(
                new Example("something", Arrays.asList(1, 2, 3))
        ).header(HttpHeaders.CACHE_CONTROL, "no-cache").build();
    }
}
