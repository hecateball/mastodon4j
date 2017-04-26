package mastodon4j.internal;

import java.util.function.Supplier;
import javax.net.ssl.HostnameVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hecateball
 */
class _HostnameVerifierSupplier implements Supplier<HostnameVerifier> {

    private static final Logger LOGGER = LoggerFactory.getLogger(_HostnameVerifierSupplier.class);

    @Override
    public HostnameVerifier get() {
        return (hostname, session) -> {
            _HostnameVerifierSupplier.LOGGER.trace("hostname:\t{}", hostname);
            _HostnameVerifierSupplier.LOGGER.trace("session:\t{}", session.toString());
            return true;
        };
    }

}
