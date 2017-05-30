package mastodon4j.internal;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Properties;
import java.util.function.Supplier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hecateball
 */
final class _SSLContextSupplier implements Supplier<SSLContext> {

    private static final Logger LOGGER = LoggerFactory.getLogger(_SSLContextSupplier.class);
    private final Properties properties;

    _SSLContextSupplier() {
        this.properties = new _PropertiesSupplier().get();;
    }

    @Override
    public SSLContext get() {
        try {
            TrustManager[] trustManagers = new TrustManager[]{
                new X509TrustManager() {

                    @Override
                    public void checkClientTrusted(X509Certificate[] certificates, String string) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] certificates, String string) throws CertificateException {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }};
            String secureSocketProtocol = this.properties.getProperty("mastodon.net.secureSocketProtocol");
            SSLContext context = SSLContext.getInstance(secureSocketProtocol);
            context.init(null, trustManagers, new SecureRandom());
            return context;
        } catch (NoSuchAlgorithmException | KeyManagementException exception) {
            LOGGER.error(exception.getMessage());
            //TODO: avoid to throw raw RuntimeException
            throw new RuntimeException(exception);
        }
    }
}
