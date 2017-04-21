package mastodon4j.util;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Arrays;
import java.util.Properties;
import mastodon4j.api.AppsResource;
import mastodon4j.entity.App;
import mastodon4j.entity.ClientCredential;
import mastodon4j.internal.__InternalModule;
import mastodon4j.internal.api.__InternalAPIModule;

/**
 *
 * @author hecateball
 */
public class ClientCredentialGenerator {

    private static final String REDILECT_URIS = "urn:ietf:wg:oauth:2.0:oob";
    private static final String SCOPES = "read write follow";
    @Inject
    private AppsResource resource;

    public static void main(String... args) {
        String[] parameters = new String[5];
        Arrays.fill(parameters, null);
        parameters[2] = REDILECT_URIS;
        parameters[3] = SCOPES;
        System.arraycopy(args, 0, parameters, 0, args.length);
        Injector injector = Guice.createInjector(new __InternalModule(), new __InternalAPIModule());

        ClientCredentialGenerator generator = injector.getInstance(ClientCredentialGenerator.class);
        ClientCredential clientCredential = generator.generate(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4]);
        System.out.println("client_id:\t" + clientCredential.getClientId());
        System.out.println("client_secret:\t" + clientCredential.getClientSecret());
    }

    public static void generate(String uri, String clientName) {
        ClientCredentialGenerator.main(uri, clientName, REDILECT_URIS, SCOPES, null);
    }

    public static void generate(String uri, String clientName, String website) {
        ClientCredentialGenerator.main(uri, clientName, REDILECT_URIS, SCOPES, website);
    }

    public ClientCredential generate(String uri, String clientName, String redirectUris, String scopes, String website) {
        Properties properties = new Properties();
        properties.put("mastodon4j.uri", uri);
        App app = new App();
        app.setName(clientName);
        app.setWebsite(website);
        return resource.registerApplication(app, redirectUris, scopes);
    }
}
