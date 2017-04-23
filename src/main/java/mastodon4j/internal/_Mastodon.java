package mastodon4j.internal;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import mastodon4j.Mastodon;
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
import mastodon4j.entity.AccessToken;
import mastodon4j.entity.Account;
import mastodon4j.entity.App;
import mastodon4j.entity.Attachment;
import mastodon4j.entity.Card;
import mastodon4j.entity.ClientCredential;
import mastodon4j.entity.Context;
import mastodon4j.entity.Instance;
import mastodon4j.entity.Notification;
import mastodon4j.entity.Relationship;
import mastodon4j.entity.Report;
import mastodon4j.entity.Results;
import mastodon4j.entity.Status;
import mastodon4j.streaming.UserStream;

/**
 *
 * @author hecateball
 */
@Singleton
class _Mastodon implements Mastodon {

    @Inject
    private AppsResource apps;
    @Inject
    private OauthResource oauth;
    @Inject
    private StreamingResource streaming;

    @Override
    public AccountsResource accounts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AppsResource apps() {
        return this.apps;
    }

    @Override
    public BlocksResource blocks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FavouritesResource favourites() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FollowRequestsResource followRequests() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FollowsResource follows() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public InstancesResource instances() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MediaResource media() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MutesResource mutes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public NotificationsResource notifications() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OauthResource oauth() {
        return this.oauth;
    }

    @Override
    public ReportsResource reports() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SearchResource search() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public StatusesResource statuses() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public StreamingResource streaming() {
        return this.streaming;
    }

    @Override
    public TimelinesResource timelines() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account verifyCredentials() {
        return accounts().verifyCredentials();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCredentials(String displayName, String note, String avatar, String header) {
        this.accounts().updateCredentials(displayName, note, avatar, header);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account getAccount(long id) {
        return this.accounts().getAccount(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account[] getFollowers(long id) {
        return this.accounts().getFollowers(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account[] getFollowing(long id) {
        return this.accounts().getFollowing(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status[] getStatuses(long id) {
        return this.accounts().getStatuses(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship follow(long id) {
        return this.accounts().follow(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship unfollow(long id) {
        return this.accounts().unfollow(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship block(long id) {
        return this.accounts().block(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship unblock(long id) {
        return this.accounts().unblock(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship mute(long id) {
        return this.accounts().mute(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship unmute(long id) {
        return this.accounts().unmute(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Relationship[] relationships(long... ids) {
        return this.accounts().relationships(ids);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account[] search(String query, long limit) {
        return this.accounts().search(query, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClientCredential registerApplication(App app, String redirectUris, String scopes) {
        return this.apps().registerApplication(app, redirectUris, scopes);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account[] getBlocks() {
        return this.blocks().getBlocks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status[] getFavourites() {
        return this.favourites().getFavourites();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account[] getFollowRequests() {
        return this.followRequests().getFollowRequests();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void authorizeFollowRequest(long id) {
        this.followRequests().authorizeFollowRequest(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rejectFollowRequest(long id) {
        this.followRequests().rejectFollowRequest(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account follow(String uri) {
        return this.follows().follow(uri);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instance getInstance() {
        return this.instances().getInstance();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Attachment postMedia(String file) {
        return this.media().postMedia(file);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account[] getMutes() {
        return this.mutes().getMutes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Notification[] getNotifications() {
        return this.notifications().getNotifications();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Notification getNotification(long id) {
        return this.notifications().getNotification(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clearNotifications() {
        this.notifications().clearNotifications();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccessToken issueAccessToken(String clientId, String clientSecret, String emailAddress, String password) {
        return this.oauth().issueAccessToken(clientId, clientSecret, emailAddress, password);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Report[] getReports() {
        return this.reports().getReports();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Report postReport(long accountId, long[] statusIds, String comment) {
        return this.reports().postReport(accountId, statusIds, comment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Results search(String query, boolean resolve) {
        return this.search().search(query, resolve);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status getStatus(long id) {
        return this.statuses().getStatus(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Context getContext(long id) {
        return this.statuses().getContext(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Card getCard(long id) {
        return this.statuses().getCard(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account[] getRebloggedBy(long id) {
        return this.statuses().getRebloggedBy(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account[] getFavouritedBy(long id) {
        return this.statuses().getFavouritedBy(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status postStatus(String status, long inReplyToId, long[] mediaIds, boolean sensitive, String spoilerText, String visibility) {
        return this.statuses().postStatus(status, inReplyToId, mediaIds, sensitive, spoilerText, visibility);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteStatus(long id) {
        this.statuses().deleteStatus(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status reblog(long id) {
        return this.statuses().reblog(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status unreblog(long id) {
        return this.statuses().unreblog(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status favourites(long id) {
        return this.statuses().favourites(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status unfavourites(long id) {
        return this.statuses().unfavourites(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserStream userEvents() {
        return this.streaming().userEvents();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void publicStatuses() {
        this.streaming().publicStatuses();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hashtagStatuses(String tag) {
        this.streaming().hashtagStatuses(tag);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status[] getHomeTimeline() {
        return this.timelines().getHomeTimeline();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status[] getPublicTimeline(boolean local) {
        return this.timelines().getPublicTimeline(local);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status[] getTagTimeline(String hashtag, boolean local) {
        return this.timelines().getTagTimeline(hashtag, local);
    }

}
