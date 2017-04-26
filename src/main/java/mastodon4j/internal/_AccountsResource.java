package mastodon4j.internal;

import java.util.Properties;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.OK;
import mastodon4j.api.AccountsResource;
import mastodon4j.entity.Account;
import mastodon4j.entity.Error;
import mastodon4j.entity.Relationship;
import mastodon4j.entity.Status;

/**
 *
 * @author hecateball
 */
class _AccountsResource implements AccountsResource {

    private final String uri;
    private final String accessToken;
    private final Client client;

    _AccountsResource() {
        Properties properties = new _PropertiesSupplier().get();
        this.uri = properties.getProperty("mastodon4j.uri");
        this.accessToken = "Bearer " + properties.getProperty("mastodon4j.accessToken");
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
    public void updateCredentials(String displayName, String note, String avatar, String header) {
        Form form = new Form();
        throw new UnsupportedOperationException("Not supported yet.");
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

    @Override
    public Account[] getFollowers(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/accounts/{id}/followers")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
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

    @Override
    public Account[] getFollowing(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/accounts/{id}/following")
                .resolveTemplate("id", id)
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

    @Override
    public Status[] getStatuses(long id) {
        Response response = this.client.target(this.uri)
                .path("/api/v1/accounts/{id}/statuses")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
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

    @Override
    public Relationship[] relationships(long... ids) {
        WebTarget target = this.client.target(this.uri)
                .path("/api/v1/accounts/relationships");
        for (long id : ids) {
            target = target.queryParam("id[]", id);
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
