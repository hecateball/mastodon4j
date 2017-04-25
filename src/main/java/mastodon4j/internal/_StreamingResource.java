package mastodon4j.internal;

import com.google.inject.Inject;
import java.util.Properties;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;
import mastodon4j.api.StreamingResource;
import mastodon4j.entity.Tag;
import mastodon4j.streaming.HashtagStream;
import mastodon4j.streaming.PublicStream;
import mastodon4j.streaming.UserStream;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.media.sse.EventSource;

/**
 *
 * @author hecateball
 */
class _StreamingResource implements StreamingResource {

    @Inject
    private Properties properties;
    @Inject
    private Client client;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserStream userStream() {
        Feature feature = OAuth2ClientSupport.feature(this.properties.getProperty("mastodon4j.accessToken"));
        WebTarget target = this.client.register(feature)
                .target(this.properties.getProperty("mastodon4j.uri"))
                .path("/api/v1/streaming/user");
        EventSource source = EventSource.target(target).build();
        return new _UserStream(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PublicStream publicStream() {
        return this.publicStream(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PublicStream publicStream(boolean local) {
        Feature feature = OAuth2ClientSupport.feature(this.properties.getProperty("mastodon4j.accessToken"));
        WebTarget target = this.client.register(feature)
                .target(this.properties.getProperty("mastodon4j.uri"))
                .path("/api/v1/streaming/public");
        if (local) {
            target = target.path("local");
        }
        return new _PublicStream(EventSource.target(target).build());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HashtagStream hashtagStream(Tag tag) {
        return this.hashtagStream(tag, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HashtagStream hashtagStream(Tag tag, boolean local) {
        Feature feature = OAuth2ClientSupport.feature(this.properties.getProperty("mastodon4j.accessToken"));
        WebTarget target = this.client.register(feature)
                .target(this.properties.getProperty("mastodon4j.uri"))
                .path("/api/v1/streaming/hashtag");
        if (local) {
            target = target.path("local");
        }
        target.queryParam("tag", tag.getName());
        return new _HashtagStream(EventSource.target(target).build());
    }

}
