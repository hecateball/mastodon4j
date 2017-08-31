package mastodon4j.internal;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mastodon4j.api.FollowRequestsResource;
import mastodon4j.entity.Account;

/**
 *
 * @author hecateball
 */
final class _FollowRequestsResource implements FollowRequestsResource {

    private final String uri;
    private final String accessToken;
    private final Client client;

    _FollowRequestsResource(String uri, String accessToken) {
        this.uri = uri;
        this.accessToken = accessToken;
        this.client = new _ClientSupplier().get();
    }

    @Override
    public Account[] getFollowRequests() {
        //TODO: need to support: max_id, since_id, limit
        Response response = this.client.target(this.uri)
                .path("/api/v1/follow_requests")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Account[].class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public void authorizeFollowRequest(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/follow_requests/{id}/authorize")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .post(null);
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return;
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public void rejectFollowRequest(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/follow_requests/{id}/reject")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .post(null);
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return;
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

}
