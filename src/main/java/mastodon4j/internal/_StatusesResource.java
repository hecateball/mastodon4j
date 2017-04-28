package mastodon4j.internal;

import java.util.Properties;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mastodon4j.api.StatusesResource;
import mastodon4j.entity.Account;
import mastodon4j.entity.Card;
import mastodon4j.entity.Context;
import mastodon4j.entity.Status;

/**
 *
 * @author hecateball
 */
public class _StatusesResource implements StatusesResource {

    private final String uri;
    private final String accessToken;
    private final Client client;

    _StatusesResource() {
        Properties properties = new _PropertiesSupplier().get();
        this.uri = properties.getProperty("mastodon4j.uri");
        this.accessToken = "Bearer " + properties.getProperty("mastodon4j.accessToken");
        this.client = new _ClientSupplier().get();
    }

    @Override
    public Status getStatus(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/stauses/{id}")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Status.class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public Context getContext(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/stauses/{id}/context")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Context.class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public Card getCard(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/stauses/{id}/card")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Card.class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public Account[] getRebloggedBy(long id) {
        //TODO: need to support: max_id, since_id, limit
        Response response = this.client.target(this.uri)
                .path("/api/v1/stauses/{id}/reblogged_by")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
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
    public Account[] getFavouritedBy(long id) {
        //TODO: need to support: max_id, since_id, limit
        Response response = this.client.target(this.uri)
                .path("/api/v1/stauses/{id}/favourited_by")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
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
    public Status postStatus(String status, long inReplyToId, long[] mediaIds, boolean sensitive, String spoilerText, String visibility) {
        //TODO: Support other parameters
        Form form = new Form()
                .param("status", status)
                .param("sensitive", String.valueOf(false))
                .param("visibility", visibility);

        Response response = this.client.target(this.uri)
                .path("/api/v1/stauses")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .post(Entity.form(form));
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        switch (response.getStatus()) {
            case 200:
                return response.readEntity(Status.class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public void deleteStatus(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Status reblog(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Status unreblog(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Status favourites(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Status unfavourites(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
