package mrg.api;

import org.jetbrains.annotations.NotNull;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/path/param/{name}")
public final class PathParamREST {

    @GET
    public @NotNull String get(@PathParam("name") String name) {
        return "Hello " + name + '!';
    }
}
