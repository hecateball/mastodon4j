package mastodon4j.internal;

import java.util.function.Supplier;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author hecateball
 */
class _ClientConfigSupplier implements Supplier<ClientConfig> {

    private static final ClientConfig CLIENT_CONFIG = new ClientConfig();

    @Override
    public ClientConfig get() {
        return CLIENT_CONFIG;
    }

}
