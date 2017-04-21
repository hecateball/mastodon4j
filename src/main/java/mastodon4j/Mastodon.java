package mastodon4j;

import mastodon4j.api.AccountsResource;
import mastodon4j.api.AppsResource;
import mastodon4j.api.BlocksResource;
import mastodon4j.api.FavouritesResource;
import mastodon4j.api.FollowRequestsResource;
import mastodon4j.api.FollowsResource;
import mastodon4j.api.InstancesResource;
import mastodon4j.api.MediaResource;
import mastodon4j.api.MutesResource;
import mastodon4j.api.NotificationsResource;
import mastodon4j.api.OauthResource;
import mastodon4j.api.ReportsResource;
import mastodon4j.api.SearchResource;
import mastodon4j.api.StatusesResource;
import mastodon4j.api.StreamingResource;
import mastodon4j.api.TimelinesResource;

/**
 *
 * @author hecateball
 */
public interface Mastodon extends AccountsResource, AppsResource, BlocksResource, FavouritesResource,
        FollowRequestsResource, FollowsResource, InstancesResource, MediaResource, MutesResource, NotificationsResource,
        OauthResource, ReportsResource, SearchResource, StatusesResource, StreamingResource, TimelinesResource {

    public AccountsResource accounts();

    public AppsResource apps();

    public BlocksResource blocks();

    public FavouritesResource favourites();

    public FollowRequestsResource followRequests();

    public FollowsResource follows();

    public InstancesResource instances();

    public MediaResource media();

    public MutesResource mutes();

    public NotificationsResource notifications();

    public OauthResource oauth();

    public ReportsResource reports();

    public SearchResource search();

    public StatusesResource statuses();

    public StreamingResource streaming();

    public TimelinesResource timelines();
}
