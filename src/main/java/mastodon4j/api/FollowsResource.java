package mastodon4j.api;

import mastodon4j.entity.Account;

/**
 *
 * @author hecateball
 */
public interface FollowsResource {

    /**
     * Following a remote user.
     *
     * @param uri username@domain of the person you want to follow
     * @return the local representation of the followed account, as an Account
     */
    public Account follow(String uri);
}
