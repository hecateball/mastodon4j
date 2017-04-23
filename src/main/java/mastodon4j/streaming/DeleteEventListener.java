package mastodon4j.streaming;

/**
 *
 * @author hecateball
 */
public interface DeleteEventListener {

    default public void onDelete(long id) {
    }
}
