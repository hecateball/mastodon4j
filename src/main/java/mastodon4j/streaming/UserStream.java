package mastodon4j.streaming;

/**
 *
 * @author hecateball
 */
public interface UserStream extends EventStream {

    public UserStream register(UserStreamListener listener);

}
