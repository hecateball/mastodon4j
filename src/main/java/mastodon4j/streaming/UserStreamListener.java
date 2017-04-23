package mastodon4j.streaming;

import mastodon4j.entity.Notification;
import mastodon4j.entity.Status;

/**
 *
 * @author hecateball
 */
public interface UserStreamListener {

    default public void onUpdate(Status status) {
    }

    default public void onNotification(Notification notification) {
    }

    default public void onDelete(long id) {
    }
}
