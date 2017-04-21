package mastodon4j.api;

import mastodon4j.entity.Account;
import mastodon4j.entity.Relationship;
import mastodon4j.entity.Status;

/**
 *
 * @author hecateball
 */
public interface AccountsResource {

    /**
     * Getting the current user.
     *
     * @return the authenticated user's Account
     */
    public Account verifyCredentials();

    /**
     * Updating the current user.
     *
     * @param displayName the name to display in the user's profile
     * @param note a new biography for the user
     * @param avatar a base64 encoded image to display as the user's avatar (e.g.
     * data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAUoAAADrCAYAAAA...)
     * @param header a base64 encoded image to display as the user's header image (e.g.
     * data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAUoAAADrCAYAAAA...)
     */
    public void updateCredentials(String displayName, String note, String avatar, String header);

    /**
     * Fetching an account.
     *
     * @param id
     * @return an Account
     */
    public Account getAccount(long id);

    /**
     * Getting an account's followers.
     *
     * @param id
     * @return an array of Accounts
     */
    public Account[] getFollowers(long id);

    /**
     * Getting who account is following.
     *
     * @param id
     * @return an array of Accounts
     */
    public Account[] getFollowing(long id);

    /**
     * Getting an account's statuses.
     *
     * @param id
     * @return an array of Statuses
     */
    public Status[] getStatuses(long id);

    /**
     * Following an account.
     *
     * @param id
     * @return the target account's Relationship.
     */
    public Relationship follow(long id);

    /**
     * Unfollowing an account.
     *
     * @param id
     * @return the target account's Relationship.
     */
    public Relationship unfollow(long id);

    /**
     * Blocking an account.
     *
     * @param id
     * @return the target account's Relationship.
     */
    public Relationship block(long id);

    /**
     * Unblocking an account.
     *
     * @param id
     * @return the target account's Relationship.
     */
    public Relationship unblock(long id);

    /**
     * Muting an account.
     *
     * @param id
     * @return the target account's Relationship.
     */
    public Relationship mute(long id);

    /**
     * Unmuting an account.
     *
     * @param id
     * @return the target account's Relationship.
     */
    public Relationship unmute(long id);

    /**
     * Getting an account's relationships.
     *
     * @param ids
     * @return an array of Relationships of the current user to a list of given accounts.
     */
    public Relationship[] relationships(long... ids);

    /**
     * Searching for accounts.
     *
     * @param query what to search for
     * @param limit maximum number of matching accounts to return (default: 40)
     * @return an array of matching Accounts. Will lookup an account remotely if the search term is in the
     * username@domain format and not yet in the database.
     */
    public Account[] search(String query, long limit);
}
