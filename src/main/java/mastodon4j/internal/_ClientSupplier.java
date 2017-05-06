package mastodon4j.internal;

import java.util.Properties;
import java.util.function.Supplier;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author hecateball
 */
final class _ClientSupplier implements Supplier<Client> {

    private static Client client;

    _ClientSupplier() {
        if (_ClientSupplier.client == null) {
            Properties properties = new _PropertiesSupplier().get();
            ClientBuilder builder = ClientBuilder.newBuilder().withConfig(new _ClientConfigSupplier().get());
            boolean useSSL = Boolean.parseBoolean(properties.getProperty("mastodon4j.net.useSSL"));
            if (useSSL) {
                builder.sslContext(new _SSLContextSupplier().get())
                        .hostnameVerifier(new _HostnameVerifierSupplier().get());
            }
            _ClientSupplier.client = builder.build();
        }
    }

    @Override
    public Client get() {
        return _ClientSupplier.client;
    }

}
