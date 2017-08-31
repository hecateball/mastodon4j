package mastodon4j.internal;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mastodon4j.api.MutesResource;
import mastodon4j.entity.Account;

/**
 *
 * @author hecateball
 */
final class _MutesResource implements MutesResource {

    private final String uri;
    private final String bearerToken;
    private final Client client;

    _MutesResource(String uri, String accessToken) {
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);;
        this.client = new _ClientSupplier().get();
    }

    @Override
    public Account[] getMutes() {
        //TODO: need to support: max_id, since_id, limit
        Response response = this.client.target(this.uri)
                .path("/api/v1/mutes")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Account[].class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

}
