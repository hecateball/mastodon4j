package mastodon4j.api;

import mastodon4j.Range;
import mastodon4j.entity.Status;

/**
 *
 * @author hecateball
 */
public interface FavouritesResource {

    /**
     * Fetching a user's favourites.
     *
     * @return an array of Statuses favourited by the authenticated user
     */
    public Status[] getFavourites();

    /**
     * Fetching a user's favourites.
     *
     * @return an array of Statuses favourited by the authenticated user
     */
    public Status[] getFavourites(Range range);
}
