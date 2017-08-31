package mastodon4j.internal;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mastodon4j.Range;
import mastodon4j.api.BlocksResource;
import mastodon4j.entity.Account;

/**
 *
 * @author hecateball
 */
final class _BlocksResource implements BlocksResource {

    private final String uri;
    private final String bearerToken;
    private final Client client;

    _BlocksResource(String uri, String accessToken) {
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);;
        this.client = new _ClientSupplier().get();
    }

    @Override
    public Account[] getBlocks() {
        return this.getBlocks(null);
    }

    @Override
    public Account[] getBlocks(Range range) {
        WebTarget target = this.client.target(this.uri)
                .path("/api/v1/blocks");
        if (range != null) {
            if (range.getLimit().isPresent()) {
                target = target.queryParam("limit", range.getLimit().get());
            }
            if (range.getSinceId().isPresent()) {
                target = target.queryParam("since_id", range.getSinceId().get());
            }
            if (range.getMaxId().isPresent()) {
                target = target.queryParam("max_id", range.getMaxId().get());
            }
        }
        Response response = target.request(MediaType.APPLICATION_JSON)
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
