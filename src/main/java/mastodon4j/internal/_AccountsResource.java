package mastodon4j.internal;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.OK;
import mastodon4j.Range;
import mastodon4j.api.AccountsResource;
import mastodon4j.entity.Account;
import mastodon4j.entity.Error;
import mastodon4j.entity.Relationship;
import mastodon4j.entity.Status;

/**
 *
 * @author hecateball
 */
final class _AccountsResource implements AccountsResource {

    private static final long DEFAULT_LIMIT = 40;
    private final String uri;
    private final String accessToken;
    private final Client client;

    _AccountsResource(String uri, String accessToken) {
        this.uri = uri;
        this.accessToken = accessToken;
        this.client = new _ClientSupplier().get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account verifyCredentials() {
        Response response = this.client.target(this.uri)
                .path("/api/v1/accounts/verify_credentials")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Account.class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account updateCredentials(String displayName, String note, String avatar, String header) {
        Form form = new Form()
                .param("display_name", displayName)
                .param("note", note)
                .param("avatar", avatar)
                .param("header", header);
        Response response = this.client.target(this.uri)
                .path("/api/v1/accounts/update_credentials")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .method("PATCH", Entity.form(form));
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Account.class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account getAccount(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/accounts/{id}")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + this.accessToken)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Account.class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account[] getFollowers(long id) {
        return this.getFollowers(id, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account[] getFollowers(long id, Range range) {
        WebTarget target = this.client.target(this.uri)
                .path("/api/v1/accounts/{id}/followers")
                .resolveTemplate("id", id);
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
                .header("Authorization", "Bearer " + this.accessToken)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Account[].class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account[] getFollowing(long id) {
        return this.getFollowing(id, null);
    }

    @Override
    public Account[] getFollowing(long id, Range range) {
        WebTarget target = this.client.target(this.uri)
                .path("/api/v1/accounts/{id}/following")
                .resolveTemplate("id", id);
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
                .header("Authorization", this.accessToken)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Account[].class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status[] getStatuses(long id) {
        return this.getStatuses(id, false, false, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status[] getStatuses(long id, Range range) {
        return this.getStatuses(id, false, false, range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status[] getStatuses(long id, boolean onlyMedia, boolean excluedeReplies, Range range) {
        WebTarget target = this.client.target(this.uri)
                .path("/api/v1/accounts/{id}/statuses")
                .resolveTemplate("id", id);
        if (onlyMedia) {
            target = target.queryParam("only_media", onlyMedia);
        }
        if (excluedeReplies) {
            target = target.queryParam("exclude_replies", excluedeReplies);
        }
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
                .header("Authorization", this.accessToken)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Status[].class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship follow(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/accounts/{id}/follow")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .post(null);
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Relationship.class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship unfollow(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/accounts/{id}/unfollow")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .post(null);
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Relationship.class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship block(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/accounts/{id}/block")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .post(null);
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Relationship.class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship unblock(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/accounts/{id}/unblock")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .post(null);
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Relationship.class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship mute(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/accounts/{id}/mute")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .post(null);
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Relationship.class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship unmute(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/accounts/{id}/unmute")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .post(null);
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Relationship.class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship[] relationships(long id, long... ids) {
        WebTarget target = this.client.target(this.uri)
                .path("/api/v1/accounts/relationships")
                .queryParam("id[]", id);
        if (ids != null) {
            for (long i : ids) {
                target = target.queryParam("id[]", i);
            }
        }
        Response response = target.request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Relationship[].class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public Account[] search(String query) {
        return this.search(query, DEFAULT_LIMIT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account[] search(String query, long limit) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/accounts/search")
                .queryParam("q", query)
                .queryParam("limit", limit)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Account[].class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

}
