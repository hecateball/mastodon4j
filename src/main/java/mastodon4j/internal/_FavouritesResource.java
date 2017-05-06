package mastodon4j.internal;

import java.util.Properties;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mastodon4j.api.FavouritesResource;
import mastodon4j.entity.Status;

/**
 *
 * @author hecateball
 */
final class _FavouritesResource implements FavouritesResource {

    private final String uri;
    private final String accessToken;
    private final Client client;

    _FavouritesResource() {
        Properties properties = new _PropertiesSupplier().get();
        this.uri = properties.getProperty("mastodon4j.uri");
        this.accessToken = "Bearer " + properties.getProperty("mastodon4j.accessToken");
        this.client = new _ClientSupplier().get();
    }

    @Override
    public Status[] getFavourites() {
        //TODO: need to support: max_id, since_id, limit
        Response response = this.client.target(this.uri)
                .path("/api/v1/favourites")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Status[].class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

}
