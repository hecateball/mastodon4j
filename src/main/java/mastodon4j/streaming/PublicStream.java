package mastodon4j.streaming;

/**
 *
 * @author hecateball
 */
public interface PublicStream extends EventStream {

    public void register(PublicStreamListener listener);
}
