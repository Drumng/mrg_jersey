package mrg.api;

import mrg.server.ContentGenerator;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/inject")
public final class InjectREST {
    private final @NotNull ContentGenerator contentGenerator;

    @Inject
    public InjectREST(@NotNull ContentGenerator contentGenerator) {
        this.contentGenerator = contentGenerator;
    }

    @GET
    public @NotNull Response get() {
        return Response.ok(contentGenerator.content()).header(HttpHeaders.CACHE_CONTROL, "no-cache").build();
    }
}
