package mastodon4j;

import com.google.inject.Guice;
import mastodon4j.internal.__InternalModule;
import mastodon4j.internal.api.__InternalAPIModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hecateball
 */
public final class MastodonFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(MastodonFactory.class);

    private MastodonFactory() {
    }

    public static Mastodon getInstance() {
        return Guice.createInjector(new __InternalModule(), new __InternalAPIModule())
                .getInstance(Mastodon.class);
    }

    private static Mastodon createInstance() {
        return null;
//        Properties properties = MastodonFactory.loadSystemProperties();
//        return new _Mastodon(); {
//
//            private final String ACCESS_TOKEN = properties.getProperty("mastodon.accessToken", null);
//
//            @Override
//            public Account verifyCredentials() {
//                return WebTargetBuilder.build(properties)
//                        .path("/api/v1/accounts/verify_credentials")
//                        .request(MediaType.APPLICATION_JSON)
//                        .header("Authorization", "Bearer " + ACCESS_TOKEN)
//                        .get(Account.class);
//            }
//
//        };
    }

}
