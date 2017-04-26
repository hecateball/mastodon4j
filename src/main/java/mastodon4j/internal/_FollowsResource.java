package mastodon4j.internal;

import java.util.Properties;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mastodon4j.api.FollowsResource;
import mastodon4j.entity.Account;

/**
 *
 * @author hecateball
 */
class _FollowsResource implements FollowsResource {

    private final String uri;
    private final String accessToken;
    private final Client client;

    _FollowsResource() {
        Properties properties = new _PropertiesSupplier().get();
        this.uri = properties.getProperty("mastodon4j.uri");
        this.accessToken = "Bearer " + properties.getProperty("mastodon4j.accessToken");
        this.client = new _ClientSupplier().get();
    }

    @Override
    public Account follow(String uri) {
        Form form = new Form();
        form.param("uri", uri);
        Response response = this.client.target(this.uri)
                .path("/api/v1/follow_requests")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .post(Entity.form(form));
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Account.class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

}
