package mastodon4j.internal;

import com.google.inject.Provider;
import java.util.function.Supplier;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author hecateball
 */
class _ClientConfigProvider implements Provider<ClientConfig>, Supplier<ClientConfig> {

    @Override
    public ClientConfig get() {
        return new ClientConfig();
    }

}
