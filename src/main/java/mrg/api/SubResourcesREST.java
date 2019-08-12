package mrg.api;

import org.jetbrains.annotations.NotNull;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/root")
public final class SubResourcesREST {

    @GET
    @Path("/first")
    public @NotNull String first() {
        return "Hello first!";
    }

    @GET
    @Path("/second")
    public @NotNull String second() {
        return "Hello second!";
    }
}
