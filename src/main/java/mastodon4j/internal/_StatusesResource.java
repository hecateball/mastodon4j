package mastodon4j.internal;

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
final class _StatusesResource implements StatusesResource {

    private final String uri;
    private final String bearerToken;
    private final Client client;

    _StatusesResource(String uri, String accessToken) {
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);
        this.client = new _ClientSupplier().get();
    }

    @Override
    public Status getStatus(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/statuses/{id}")
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
                .path("/api/v1/statuses/{id}/context")
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
                .path("/api/v1/statuses/{id}/card")
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
                .path("/api/v1/statuses/{id}/reblogged_by")
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
                .path("/api/v1/statuses/{id}/favourited_by")
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
    public Status postStatus(Status status) {

        Form form = new Form("status", status.getContent());
        if (status.getInReplyToId() != null) {
            form = form.param("in_reply_to_id", String.valueOf(status.getInReplyToId()));
        }
        if (status.isSensitive()) {
            form = form.param("sensitive", "true");
        }
        if (status.getSpoilerText() != null && !status.getSpoilerText().isEmpty()) {
            form = form.param("spoiler_text", status.getSpoilerText());
        }
        if (status.getVisibility() != null && !status.getVisibility().isEmpty()) {
            form = form.param("visibility", status.getVisibility());
        }
        Response response = this.client.target(this.uri)
                .path("/api/v1/statuses")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post(Entity.form(form));
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Status.class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public void deleteStatus(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/statuses/{id}")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .delete();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return;
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public Status reblog(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/statuses/{id}/reblog")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post(null);
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Status.class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public Status unreblog(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/statuses/{id}/unreblog")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post(null);
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Status.class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public Status favourite(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/statuses/{id}/favourite")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post(null);
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Status.class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public Status unfavourite(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/statuses/{id}/unfavourite")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post(null);
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Status.class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

}
