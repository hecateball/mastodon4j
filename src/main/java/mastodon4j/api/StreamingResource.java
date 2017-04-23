package mastodon4j.api;

import mastodon4j.entity.Tag;
import mastodon4j.streaming.HashtagStream;
import mastodon4j.streaming.PublicStream;
import mastodon4j.streaming.UserStream;

/**
 *
 * @author hecateball
 */
public interface StreamingResource {

    /**
     * Returns events that are relevant to the authorized user, i.e. home timeline and notifications.
     *
     * @return /api/v1/streaming/user
     */
    public UserStream userStream();

    /**
     * Returns all public statuses.
     *
     * @return /api/v1/streaming/public
     */
    public PublicStream publicStream();

    /**
     * Return local public statuses.
     *
     * @param local
     * @return /api/v1/streaming/public/local
     */
    public PublicStream publicStream(boolean local);

    /**
     * Returns all public statuses for a particular hashtag.
     *
     * @param tag
     * @return /api/v1/streaming/hashtag
     */
    public HashtagStream hashtagStream(Tag tag);

    /**
     * Returns local public statuses for a particular hashtag.
     *
     * @param tag
     * @param local
     * @return /api/v1/streaming/hashtag/local
     */
    public HashtagStream hashtagStream(Tag tag, boolean local);

}
