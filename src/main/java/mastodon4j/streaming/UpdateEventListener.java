package mastodon4j.streaming;

import mastodon4j.entity.Status;

/**
 *
 * @author hecateball
 */
public interface UpdateEventListener {

    default public void onUpdate(Status status) {
    }

}
