package mastodon4j.streaming;

import mastodon4j.entity.Notification;

/**
 *
 * @author hecateball
 */
public interface NotificationEventListener {

    default public void onNotification(Notification notification) {
    }
}
