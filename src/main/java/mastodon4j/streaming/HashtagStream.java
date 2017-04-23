package mastodon4j.streaming;

/**
 *
 * @author hecateball
 */
public interface HashtagStream extends EventStream {

    public void register(HashtagStreamListener listener);
}
