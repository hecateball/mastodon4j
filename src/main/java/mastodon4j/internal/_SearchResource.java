package mastodon4j.internal;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mastodon4j.api.SearchResource;
import mastodon4j.entity.Results;

/**
 *
 * @author hecateball
 */
final class _SearchResource implements SearchResource {

    private final String uri;
    private final Client client;

    _SearchResource(String uri) {
        this.uri = uri;
        this.client = new _ClientSupplier().get();
    }

    @Override
    public Results search(String query, boolean resolve) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/search")
                .queryParam("q", query)
                .queryParam("resolve", resolve)
                .request(MediaType.APPLICATION_JSON)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Results.class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

}
