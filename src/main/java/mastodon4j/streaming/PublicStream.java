package mastodon4j.streaming;

/**
 *
 * @author hecateball
 */
public interface PublicStream extends EventStream {

    public PublicStream register(PublicStreamListener listener);
}
