package mastodon4j.api;

import mastodon4j.entity.Application;
import mastodon4j.entity.ClientCredential;

/**
 *
 * @author hecateball
 */
public interface AppsResource {

    /**
     * Registering an application.
     *
     * @param app must have name of your application
     * @param redirectUris where the user should be redirected after authorization (for no redirect, use
     * urn:ietf:wg:oauth:2.0:oob)
     * @param scopes This can be a space-separated list of the following items: "read", "write" and "follow" (see this
     * page for details on what the scopes do)
     * @return id, client_id and client_secret which can be used with OAuth authentication in your 3rd party app. These
     * values should be requested in the app itself from the API for each new app install + mastodon domain combo, and
     * stored in the app for future requests.
     */
    public ClientCredential registerApplication(Application app, String redirectUris, String scopes);

}
