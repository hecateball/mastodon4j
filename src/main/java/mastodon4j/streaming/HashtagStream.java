package mastodon4j.streaming;

/**
 *
 * @author hecateball
 */
public interface HashtagStream extends EventStream {

    public HashtagStream register(HashtagStreamListener listener);
}
