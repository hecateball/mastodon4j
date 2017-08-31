package mastodon4j.internal;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mastodon4j.api.TimelinesResource;
import mastodon4j.entity.Status;

/**
 *
 * @author hecateball
 */
final class _TimelinesResource implements TimelinesResource {

    private final String uri;
    private final String bearerToken;
    private final Client client;

    _TimelinesResource(String uri, String accessToken) {
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);;
        this.client = new _ClientSupplier().get();
    }

    @Override
    public Status[] getHomeTimeline() {
        //TODO: need to support:local, max_id, since_id, limit
        Response response = this.client.target(this.uri)
                .path("/api/v1/timelines/home")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Status[].class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public Status[] getPublicTimeline(boolean local) {
        //TODO: need to support:local, max_id, since_id, limit
        Response response = this.client.target(this.uri)
                .path("/api/v1/timelines/public")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Status[].class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public Status[] getHashtagTimeline(String hashtag, boolean local) {
        //TODO: need to support:local, max_id, since_id, limit
        Response response = this.client.target(this.uri)
                .path("/api/v1/timelines/tag/{hashtag}")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
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
