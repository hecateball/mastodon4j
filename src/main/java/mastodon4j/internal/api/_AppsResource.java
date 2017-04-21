package mastodon4j.internal.api;

import com.google.inject.Inject;
import java.util.Properties;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import mastodon4j.api.AppsResource;
import mastodon4j.entity.App;
import mastodon4j.entity.ClientCredential;

/**
 *
 * @author hecateball
 */
class _AppsResource implements AppsResource {

    @Inject
    private Properties properties;
    @Inject
    private Client client;

    /**
     * {@inheritDoc}
     */
    @Override
    public ClientCredential registerApplication(App app, String redirectUris, String scopes) {
        Form form = new Form();
        form.param("client_name", app.getName())
                .param("redirect_uris", redirectUris)
                .param("scopes", scopes);
        if (app.getWebsite() != null && !app.getWebsite().isEmpty()) {
            form.param("website", app.getWebsite());
        }

        return this.client
                .target(this.properties.getProperty("mastodon4j.uri"))
                .path("/api/v1/apps")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.form(form), ClientCredential.class);
    }

}
