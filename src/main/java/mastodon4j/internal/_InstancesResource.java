package mastodon4j.internal;

import java.util.Properties;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mastodon4j.api.InstancesResource;
import mastodon4j.entity.Instance;

/**
 *
 * @author hecateball
 */
final class _InstancesResource implements InstancesResource {

    private final String uri;
    private final Client client;

    _InstancesResource() {
        Properties properties = new _PropertiesSupplier().get();
        this.uri = properties.getProperty("mastodon4j.uri");
        this.client = new _ClientSupplier().get();
    }

    @Override
    public Instance getInstance() {
        Response response = this.client.target(this.uri)
                .path("/api/v1/instance")
                .request(MediaType.APPLICATION_JSON)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Instance.class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

}
