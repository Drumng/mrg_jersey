package mrg.server;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("Duplicates")
public final class EasyHttpWeb {

    public static void main(@NotNull String[] args) throws Exception {
        final Server server = new Server();
        final HttpConfiguration httpConfig = new HttpConfiguration();
        final HttpConnectionFactory httpConnectionFactory = new HttpConnectionFactory(httpConfig);
        final ServerConnector serverConnector = new ServerConnector(server, httpConnectionFactory);
        serverConnector.setHost("localhost");
        serverConnector.setPort(3466);
        server.setConnectors(new Connector[]{serverConnector});

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.addServlet(HttpServletDispatcher.class, "/*");
        context.addEventListener(new GuiceListener());

        server.setHandler(context);

        server.start();
    }
}
