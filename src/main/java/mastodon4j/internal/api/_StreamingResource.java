package mastodon4j.internal.api;

import com.google.inject.Inject;
import java.util.Properties;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;
import mastodon4j.api.StreamingResource;
import mastodon4j.streaming.UserStream;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.media.sse.EventListener;
import org.glassfish.jersey.media.sse.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hecateball
 */
public class _StreamingResource implements StreamingResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(_StreamingResource.class);
    @Inject
    private Properties properties;
    @Inject
    private Client client;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserStream userEvents() {
        Feature feature = OAuth2ClientSupport.feature(this.properties.getProperty("mastodon4j.accessToken"));
        WebTarget target = this.client.register(feature)
                .target(this.properties.getProperty("mastodon4j.uri"))
                .path("/api/v1/streaming/user");
        EventSource source = EventSource.target(target).build();
        return new UserStream(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void publicStatuses() {
        Feature feature = OAuth2ClientSupport.feature(this.properties.getProperty("mastodon4j.accessToken"));
        WebTarget target = this.client.register(feature)
                .target(this.properties.getProperty("mastodon4j.uri"))
                .path("/api/v1/streaming/public");
        EventSource s = EventSource.target(target).build();
        EventListener listener = event -> LOGGER.info("{}\t{}", event.getName(), event.readData(String.class));
        s.register(listener);
        s.open();
//                .request(MediaType.APPLICATION_JSON)
//                .header("Authorization", "Bearer " + this.properties.getProperty("mastodon4j.accessToken"))
//                .;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hashtagStatuses(String tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
