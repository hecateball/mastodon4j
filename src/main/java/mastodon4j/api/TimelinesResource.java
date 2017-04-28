package mastodon4j.api;

import mastodon4j.entity.Status;

/**
 *
 * @author hecateball
 */
public interface TimelinesResource {

    /**
     * Retrieving a home timeline.
     *
     * @return an array of Statuses, most recent ones first
     */
    public Status[] getHomeTimeline();

    /**
     * Retrieving a public timeline.
     *
     * @param local (optional) only return statuses originating from this instance
     * @return an array of Statuses, most recent ones first
     */
    public Status[] getPublicTimeline(boolean local);

    /**
     * Retrieving a tag timeline.
     *
     * @param hashtag
     * @param local (optional) only return statuses originating from this instance
     * @return an array of Statuses, most recent ones first
     */
    public Status[] getHashtagTimeline(String hashtag, boolean local);
}
