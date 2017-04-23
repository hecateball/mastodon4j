package mastodon4j.streaming;

/**
 *
 * @author hecateball
 */
public interface UserStream extends EventStream {

    public void register(UserStreamListener listener);

}
