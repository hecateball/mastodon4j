package mastodon4j.api;

/**
 *
 * @author hecateball
 */
public interface StreamingResource {

    /**
     * Returns events that are relevant to the authorized user, i.e. home timeline and notifications.
     */
    public void userEvents();

    /**
     * Returns all public statuses.
     */
    public void publicStatuses();

    /**
     * Returns all public statuses for a particular hashtag.
     *
     * @param tag
     */
    public void hashtagStatuses(String tag);

}
