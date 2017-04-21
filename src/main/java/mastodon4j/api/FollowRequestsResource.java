package mastodon4j.api;

import mastodon4j.entity.Account;

/**
 *
 * @author hecateball
 */
public interface FollowRequestsResource {

    /**
     * Fetching a list of follow requests.
     *
     * @return an array of Accounts which have requested to follow the authenticated user
     */
    public Account[] getFollowRequests();

    /**
     * Authorizing follow requests.
     *
     * @param id
     */
    public void authorizeFollowRequest(long id);

    /**
     * Rejecting follow requests.
     *
     * @param id
     */
    public void rejectFollowRequest(long id);
}
