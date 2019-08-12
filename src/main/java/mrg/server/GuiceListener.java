package mrg.server;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import mrg.api.*;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletContext;
import java.util.Collections;
import java.util.List;

public final class GuiceListener extends GuiceResteasyBootstrapServletContextListener {
    @Override
    protected @NotNull List<? extends Module> getModules(@NotNull ServletContext context) {
        return Collections.singletonList(new GuiceModule());
    }

    private static final class GuiceModule extends AbstractModule {
        @SuppressWarnings("PointlessBinding")
        @Override
        protected void configure() {
            bind(JacksonMessageBodyHandler.class).toInstance(new JacksonMessageBodyHandler());
            bind(InjectREST.class);
            bind(PathParamREST.class);
            bind(FormParamREST.class);
            bind(ConsumesREST.class);
            bind(JsonREST.class);
            bind(PathREST.class);
            bind(ProducesREST.class);
            bind(QueryParamREST.class);
            bind(SubResourcesREST.class);
        }
    }
}
