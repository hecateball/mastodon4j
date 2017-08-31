package mastodon4j.internal;

import java.util.Arrays;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mastodon4j.api.ReportsResource;
import mastodon4j.entity.Error;
import mastodon4j.entity.Report;

/**
 *
 * @author hecateball
 */
final class _ReportsResource implements ReportsResource {

    private final String uri;
    private final String accessToken;
    private final Client client;

    _ReportsResource(String uri, String accessToken) {
        this.uri = uri;
        this.accessToken = accessToken;
        this.client = new _ClientSupplier().get();
    }

    @Override
    public Report[] getReports() {
        Response response = this.client.target(this.uri)
                .path("/api/v1/reports")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .get();
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Report[].class);
            default:
                mastodon4j.entity.Error error = response.readEntity(mastodon4j.entity.Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

    @Override
    public Report postReport(long accountId, long[] statusIds, String comment) {
        //TODO: NOT WORKING?
        Form form = new Form();
        form.param("account_id", String.valueOf(accountId));
        Arrays.stream(statusIds)
                .mapToObj(String::valueOf)
                .forEach(statusId -> form.param("status_ids", statusId));
        form.param("comment", comment);
        Response response = this.client.target(this.uri)
                .path("/api/v1/reports")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", this.accessToken)
                .post(Entity.form(form));
        switch (Response.Status.fromStatusCode(response.getStatus())) {
            case OK:
                return response.readEntity(Report.class);
            default:
                Error error = response.readEntity(Error.class);
                throw new WebApplicationException(error.getError(), response.getStatus());
        }
    }

}
