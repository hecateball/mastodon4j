package mastodon4j.internal;

import java.util.function.Supplier;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;

/**
 *
 * @author hecateball
 */
final class _ClientConfigSupplier implements Supplier<ClientConfig> {

    private static ClientConfig clientConfig;

    _ClientConfigSupplier() {
        if (_ClientConfigSupplier.clientConfig == null) {
            _ClientConfigSupplier.clientConfig = new ClientConfig();
            //Enable PATCH method
            _ClientConfigSupplier.clientConfig.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
        }
    }

    @Override
    public ClientConfig get() {
        return _ClientConfigSupplier.clientConfig;
    }

}
