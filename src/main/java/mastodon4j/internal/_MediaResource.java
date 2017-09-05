package mastodon4j.internal;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mastodon4j.api.MediaResource;
import mastodon4j.entity.Attachment;

/**
 *
 * @author hecateball
 */
final class _MediaResource implements MediaResource {

    private final String uri;
    private final String bearerToken;
    private final Client client;

    _MediaResource(String uri, String accessToken) {
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);
        this.client = new _ClientSupplier().get();
    }

    @Override
    public Attachment postMedia(String file) {
        Form form = new Form();
        form.param("media", file);
        Response response = this.client.target(this.uri)
                .path("/api/v1/favourites")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post(Entity.form(form));
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Attachment.class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

}
