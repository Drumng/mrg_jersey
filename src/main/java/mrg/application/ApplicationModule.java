package mrg.application;

import com.google.inject.AbstractModule;
import com.google.inject.servlet.ServletModule;
import mrg.server.ContentGenerator;
import mrg.server.JacksonMessageBodyHandler;

public final class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ServletModule());
        bind(ContentGenerator.class).toInstance(new ContentGenerator());
    }
}
