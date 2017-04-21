package mastodon4j;

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

    public static Mastodon getInstance() throws Exception {
        return MastodonFactory.createInstance();
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
