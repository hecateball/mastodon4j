package mastodon4j.api;

import mastodon4j.entity.Instance;

/**
 *
 * @author hecateball
 */
public interface InstancesResource {

    /**
     * Getting instance information.
     *
     * @return the current Instance. Does not require authentication
     */
    public Instance getInstance();
}
