package mastodon4j.internal;

import com.google.inject.Inject;
import java.util.Properties;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import mastodon4j.api.OauthResource;
import mastodon4j.entity.AccessToken;

/**
 *
 * @author hecateball
 */
class _OauthResource implements OauthResource {

    @Inject
    private Properties properties;
    @Inject
    private Client client;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccessToken issueAccessToken(String clientId, String clientSecret, String emailAddress, String password, String scopes) {
        //   try {
        Form form = new Form();
        form.param("client_id", clientId)
                .param("client_secret", clientSecret)
                .param("username", emailAddress)
                .param("password", password)
                .param("scope", scopes)
                .param("grant_type", "password");
        return this.client
                .target(this.properties.getProperty("mastodon4j.uri"))
                .path("/oauth/token")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.form(form), AccessToken.class);
//        } catch (UnsupportedEncodingException exception) {
//            throw new WebApplicationException(exception);
//        }
    }

}
