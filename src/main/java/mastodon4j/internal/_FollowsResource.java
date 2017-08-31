package mastodon4j.internal;

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
final class _FollowsResource implements FollowsResource {

    private final String uri;
    private final String bearerToken;
    private final Client client;

    _FollowsResource(String uri, String accessToken) {
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);;
        this.client = new _ClientSupplier().get();
    }

    @Override
    public Account follow(String uri) {
        Form form = new Form();
        form.param("uri", uri);
        Response response = this.client.target(this.uri)
                .path("/api/v1/follow_requests")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
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
