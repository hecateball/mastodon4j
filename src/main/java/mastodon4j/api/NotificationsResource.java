package mastodon4j.api;

import mastodon4j.entity.Notification;

/**
 *
 * @author hecateball
 */
public interface NotificationsResource {

    /**
     * Fetching a user's notifications.
     *
     * @return a list of Notifications for the authenticated user
     */
    public Notification[] getNotifications();

    /**
     * Getting a single notification.
     *
     * @param id
     * @return the Notification
     */
    public Notification getNotification(long id);

    /**
     * Clearing notifications. Deletes all notifications from the Mastodon server for the authenticated user.
     */
    public void clearNotifications();

}
