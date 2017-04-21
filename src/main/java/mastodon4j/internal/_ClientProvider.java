package mastodon4j.internal;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Properties;
import java.util.function.Supplier;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author hecateball
 */
class _ClientProvider implements Provider<Client>, Supplier<Client> {

    @Inject
    private Properties properties;
    @Inject
    private ClientConfig clientConfig;
    @Inject
    private SSLContext context;
    @Inject
    private HostnameVerifier verifier;

    @Override
    public Client get() {
        ClientBuilder builder = ClientBuilder.newBuilder().withConfig(this.clientConfig);
        boolean useSSL = Boolean.parseBoolean(this.properties.getProperty("mastodon4j.net.useSSL"));
        if (useSSL) {
            builder.sslContext(this.context)
                    .hostnameVerifier(this.verifier);
        }
        return builder.build();
    }

}
