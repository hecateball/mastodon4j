package mastodon4j.api;

import mastodon4j.entity.AccessToken;

/**
 *
 * @author hecateball
 */
public interface OauthResource {

    /**
     * Attempt to login with the given credentials, and then retrieve the access token for the current user.
     *
     * @param clientId
     * @param clientSecret
     * @param emailAddress
     * @param password
     * @return an AccessToken
     */
    public AccessToken issueAccessToken(String clientId, String clientSecret, String emailAddress, String password);
}
