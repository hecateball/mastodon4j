package mastodon4j.api;

import mastodon4j.entity.Results;

/**
 *
 * @author hecateball
 */
public interface SearchResource {

    /**
     * Searching for content.
     *
     * @param query the search query
     * @param resolve whether to resolve non-local accounts
     * @return Results. If query is a URL, Mastodon will attempt to fetch the provided account or status. Otherwise, it
     * will do a local account and hashtag search
     */
    public Results search(String query, boolean resolve);
}
