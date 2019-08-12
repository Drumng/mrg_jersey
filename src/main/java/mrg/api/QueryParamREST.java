package mrg.api;

import org.jetbrains.annotations.NotNull;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/query/param")
public final class QueryParamREST {

    @GET
    public @NotNull String get(@QueryParam("name") String name,
                               @QueryParam("age") Integer age) {
        return "Name - " + name + ", age - " + age;
    }
}
