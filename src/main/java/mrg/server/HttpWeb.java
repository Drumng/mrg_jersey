package mrg.server;

import mrg.api.PathREST;
import mrg.application.MyApplication;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("Duplicates")
public final class HttpWeb {

    public static void main(@NotNull String[] args) throws Exception {
        final Server server = new Server();
        final HttpConfiguration httpConfig = new HttpConfiguration();
        final HttpConnectionFactory httpConnectionFactory = new HttpConnectionFactory(httpConfig);
        final ServerConnector serverConnector = new ServerConnector(server, httpConnectionFactory);
        serverConnector.setHost("localhost");
        serverConnector.setPort(3466);
        server.setConnectors(new Connector[]{serverConnector});

        ServletContextHandler defaultContext = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        final ServletHolder servletHolder = defaultContext.addServlet(ServletContainer.class, "/*");
        final Map<String, String> param = new HashMap<>();
        param.put(ServletProperties.JAXRS_APPLICATION_CLASS, MyApplication.class.getName());
        param.put(ServerProperties.PROVIDER_PACKAGES, PathREST.class.getPackage().getName());
        param.put(ServerProperties.PROVIDER_CLASSNAMES, JacksonFeature.class.getName());
        servletHolder.setInitParameters(param);

        server.setHandler(defaultContext);

        server.start();
    }
}
