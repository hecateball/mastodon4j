package mastodon4j.internal;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import mastodon4j.Mastodon;
import mastodon4j.api.AccountsResource;
import mastodon4j.api.AppsResource;
import mastodon4j.api.OauthResource;
import mastodon4j.api.StreamingResource;
import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hecateball
 */
public class __InternalModule extends AbstractModule {

    private static final Properties PROPERTIES = new Properties();

    static {
        URL location = Mastodon.class.getProtectionDomain().getCodeSource().getLocation();
        try (InputStream inputStream = Files.newInputStream(Paths.get(location.getPath(), "mastodon4j.dependency.properties"), StandardOpenOption.READ)) {
            PROPERTIES.load(inputStream);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void configure() {
        try {
            // Mastodon instance
            bind(Mastodon.class).to((Class<? extends Mastodon>) Class.forName(PROPERTIES.getProperty("mastodon4j.dependency.Mastodon"))).asEagerSingleton();
            // System properties
            bind(Properties.class).toProvider((Class<? extends Provider<? extends Properties>>) Class.forName(PROPERTIES.getProperty("mastodon4j.dependency.provider.Properties"))).asEagerSingleton();
            // REST API Clients
            bind(Client.class).toProvider((Class<? extends Provider<? extends Client>>) Class.forName(PROPERTIES.getProperty("mastodon4j.dependency.provider.Client"))).asEagerSingleton();
            bind(ClientConfig.class).toProvider((Class<? extends Provider<? extends ClientConfig>>) Class.forName(PROPERTIES.getProperty("mastodon4j.dependency.provider.ClientConfig"))).asEagerSingleton();
            bind(SSLContext.class).toProvider((Class<? extends Provider<? extends SSLContext>>) Class.forName(PROPERTIES.getProperty("mastodon4j.dependency.provider.SSLContext"))).asEagerSingleton();
            bind(HostnameVerifier.class).toProvider((Class<? extends Provider<? extends HostnameVerifier>>) Class.forName(PROPERTIES.getProperty("mastodon4j.dependency.provider.HostnameVerifier"))).asEagerSingleton();
            // API Resources
            bind(AccountsResource.class).to((Class<? extends AccountsResource>) Class.forName(PROPERTIES.getProperty("mastodon4j.dependency.AccountsResource")));
            bind(AppsResource.class).to((Class<? extends AppsResource>) Class.forName(PROPERTIES.getProperty("mastodon4j.dependency.AppsResource")));
            bind(OauthResource.class).to((Class<? extends OauthResource>) Class.forName(PROPERTIES.getProperty("mastodon4j.dependency.OauthResource")));
            bind(StreamingResource.class).to((Class<? extends StreamingResource>) Class.forName(PROPERTIES.getProperty("mastodon4j.dependency.StreamingResource")));
        } catch (ClassNotFoundException exception) {
            LoggerFactory.getLogger(__InternalModule.class).error("Failed to resolve dependency", exception);
            throw new RuntimeException(exception);
        }
    }

}
