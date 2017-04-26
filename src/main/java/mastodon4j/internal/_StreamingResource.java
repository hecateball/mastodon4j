package mastodon4j.internal;

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

    private final String uri;
    private final Feature feature;
    private final Client client;

    _StreamingResource() {
        Properties properties = new _PropertiesSupplier().get();
        this.uri = properties.getProperty("mastodon4j.uri");
        this.feature = OAuth2ClientSupport.feature(properties.getProperty("mastodon4j.accessToken"));
        this.client = new _ClientSupplier().get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserStream userStream() {
        WebTarget target = this.client
                .register(this.feature)
                .target(this.uri)
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
        WebTarget target = this.client
                .register(this.feature)
                .target(this.uri)
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
        WebTarget target = this.client
                .register(this.feature)
                .target(this.uri)
                .path("/api/v1/streaming/hashtag");
        if (local) {
            target = target.path("local");
        }
        target = target.queryParam("tag", tag.getName());
        return new _HashtagStream(EventSource.target(target).build());
    }

}
