package mastodon4j.api;

import mastodon4j.entity.Account;

/**
 *
 * @author hecateball
 */
public interface BlocksResource {

    /**
     * Fetching a user's blocks.
     *
     * @return an array of Accounts blocked by the authenticated user
     */
    public Account[] getBlocks();
}
