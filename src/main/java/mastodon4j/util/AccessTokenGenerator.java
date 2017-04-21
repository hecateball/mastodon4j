package mastodon4j.util;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Properties;
import mastodon4j.api.OauthResource;
import mastodon4j.entity.AccessToken;
import mastodon4j.internal.__InternalModule;
import mastodon4j.internal.api.__InternalAPIModule;

/**
 *
 * @author hecateball
 */
public class AccessTokenGenerator {

    @Inject
    private OauthResource resource;

    public static void main(String... args) {
        String uri = args[0];
        String clientId = args[1];
        String clientSecret = args[2];
        String emailAddress = args[3];
        String password = args[4];
        Injector injector = Guice.createInjector(new __InternalModule(), new __InternalAPIModule());
        AccessTokenGenerator generator = injector.getInstance(AccessTokenGenerator.class);
        AccessToken accessToken = generator.generate(uri, clientId, clientSecret, emailAddress, password);
        System.out.println("access_token:\t" + accessToken.getAccessToken());
    }

    public AccessToken generate(String uri, String clientId, String clientSecret, String emailAddress, String password) {
        Properties properties = new Properties();
        properties.put("mastodon4j.uri", uri);
        return this.resource.issueAccessToken(clientId, clientSecret, emailAddress, password);
    }

}
