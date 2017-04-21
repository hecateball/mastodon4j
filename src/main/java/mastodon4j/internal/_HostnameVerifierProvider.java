package mastodon4j.internal;

import com.google.inject.Provider;
import java.util.function.Supplier;
import javax.net.ssl.HostnameVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hecateball
 */
class _HostnameVerifierProvider implements Provider<HostnameVerifier>, Supplier<HostnameVerifier> {

    private static final Logger LOGGER = LoggerFactory.getLogger(_HostnameVerifierProvider.class);

    @Override
    public HostnameVerifier get() {
        return (hostname, session) -> {
            _HostnameVerifierProvider.LOGGER.debug("hostname:\t{}", hostname);
            _HostnameVerifierProvider.LOGGER.debug("session:\t{}", session.toString());
            return true;
        };
    }

}
