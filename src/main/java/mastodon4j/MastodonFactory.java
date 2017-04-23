package mastodon4j;

import com.google.inject.Guice;
import mastodon4j.internal.__InternalModule;

/**
 *
 * @author hecateball
 */
public final class MastodonFactory {

    private MastodonFactory() {
    }

    public static Mastodon getInstance() {
        return Guice.createInjector(new __InternalModule())
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
