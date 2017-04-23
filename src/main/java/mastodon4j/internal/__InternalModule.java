package mastodon4j.internal;

import com.google.inject.AbstractModule;
import java.util.Properties;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import mastodon4j.Mastodon;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author hecateball
 */
public class __InternalModule extends AbstractModule {

    @Override
    protected void configure() {
        // System properties
        bind(Properties.class).toProvider(_PropertiesProvider.class);
        // Mastodon instance
        bind(Mastodon.class).to(_Mastodon.class);

        // REST API Clients
        bind(Client.class).toProvider(_ClientProvider.class);
        bind(ClientConfig.class).toProvider(_ClientConfigProvider.class);
        bind(SSLContext.class).toProvider(_SSLContextProvider.class);
        bind(HostnameVerifier.class).toProvider(_HostnameVerifierProvider.class);
    }

}
