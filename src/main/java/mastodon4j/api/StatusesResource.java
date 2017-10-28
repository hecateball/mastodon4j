package mastodon4j.api;

import mastodon4j.entity.Account;
import mastodon4j.entity.Card;
import mastodon4j.entity.Context;
import mastodon4j.entity.Status;

/**
 *
 * @author hecateball
 */
public interface StatusesResource {

    /**
     * Fetching a status.
     *
     * @param id
     * @return a Status
     */
    public Status getStatus(long id);

    /**
     * Getting status context.
     *
     * @param id
     * @return a Context
     */
    public Context getContext(long id);

    /**
     * Getting a card associated with a status.
     *
     * @param id
     * @return a Card
     */
    public Card getCard(long id);

    /**
     * Getting who reblogged a status.
     *
     * @param id
     * @return an array of Accounts
     */
    public Account[] getRebloggedBy(long id);

    /**
     * Getting who favourited a status.
     *
     * @param id
     * @return an array of Accounts
     */
    public Account[] getFavouritedBy(long id);

    /**
     * Posting a new status.
     *
     * @param status
     * @return the new Status.
     */
    public Status postStatus(Status status);

    /**
     * Deleting a status.
     *
     * @param id
     */
    public void deleteStatus(long id);

    /**
     * Reblogging a status.
     *
     * @param id
     */
    public Status reblog(long id);

    /**
     * Unreblogging a status.
     *
     * @param id
     */
    public Status unreblog(long id);

    /**
     * Favouriting a status.
     *
     * @param id
     * @return
     */
    public Status favourite(long id);

    /**
     * Unfavouriting a status.
     *
     * @param id
     * @return
     */
    public Status unfavourite(long id);
}
