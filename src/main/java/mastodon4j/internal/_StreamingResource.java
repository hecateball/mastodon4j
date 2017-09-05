package mastodon4j.internal;

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
final class _StreamingResource implements StreamingResource {

    private final String uri;
    private final Feature feature;
    private final Client client;
    private static UserStream USER_STREAM;
    private static PublicStream PUBLIC_STREAM;
    private static PublicStream LOCAL_PUBLIC_STREAM;

    _StreamingResource(String uri, String accessToken) {
        this.uri = uri;
        this.feature = OAuth2ClientSupport.feature(accessToken);
        this.client = new _ClientSupplier().get();
        //User Stream
        if (_StreamingResource.USER_STREAM == null) {
            WebTarget userStream = this.client.register(this.feature)
                    .target(uri)
                    .path("/api/v1/streaming/user");
            _StreamingResource.USER_STREAM = new _UserStream(EventSource.target(userStream).build());
        }
        //Public Stream
        if (_StreamingResource.PUBLIC_STREAM == null) {
            WebTarget publicStream = this.client.register(this.feature)
                    .target(uri)
                    .path("/api/v1/streaming/public");
            _StreamingResource.PUBLIC_STREAM = new _PublicStream(EventSource.target(publicStream).build());
        }
        //Local Public Stream
        if (_StreamingResource.LOCAL_PUBLIC_STREAM == null) {
            WebTarget locaPublicStream = this.client.register(this.feature)
                    .target(uri)
                    .path("/api/v1/streaming/public/local");
            _StreamingResource.LOCAL_PUBLIC_STREAM = new _PublicStream(EventSource.target(locaPublicStream).build());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserStream userStream() {
        return _StreamingResource.USER_STREAM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PublicStream publicStream() {
        return _StreamingResource.PUBLIC_STREAM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PublicStream publicStream(boolean local) {
        return local ? _StreamingResource.LOCAL_PUBLIC_STREAM : _StreamingResource.PUBLIC_STREAM;
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
        WebTarget target = this.client.register(this.feature)
                .target(this.uri)
                .path("/api/v1/streaming/hashtag");
        if (local) {
            target = target.path("local");
        }
        target = target.queryParam("tag", tag.getName());
        return new _HashtagStream(EventSource.target(target).build());
    }

}
