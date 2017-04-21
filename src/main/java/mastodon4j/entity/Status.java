package mastodon4j.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hecateball
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Status implements Serializable {

    private static final long serialVersionUID = -5976946573675678719L;
    private long id;
    private String uri;
    private String url;
    private Account account;
    private long inReplyToId;
    private long inReplyToAccountId;
    private Status reblog;
    private String content;
    private long createdAt;
    private long reblogsCount;
    private long favouritesCount;
    private boolean reblogged;
    private boolean favourited;
    private boolean sensitive;
    private String spoilerText;
    private String visibility;
    private Attachment[] mediaAttachments;
    private Mention[] mentions;
    private Tag[] tags;
    private App app;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public long getInReplyToId() {
        return inReplyToId;
    }

    public void setInReplyToId(long inReplyToId) {
        this.inReplyToId = inReplyToId;
    }

    public long getInReplyToAccountId() {
        return inReplyToAccountId;
    }

    public void setInReplyToAccountId(long inReplyToAccountId) {
        this.inReplyToAccountId = inReplyToAccountId;
    }

    public Status getReblog() {
        return reblog;
    }

    public void setReblog(Status reblog) {
        this.reblog = reblog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getReblogsCount() {
        return reblogsCount;
    }

    public void setReblogsCount(long reblogsCount) {
        this.reblogsCount = reblogsCount;
    }

    public long getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(long favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public boolean isReblogged() {
        return reblogged;
    }

    public void setReblogged(boolean reblogged) {
        this.reblogged = reblogged;
    }

    public boolean isFavourited() {
        return favourited;
    }

    public void setFavourited(boolean favourited) {
        this.favourited = favourited;
    }

    public boolean isSensitive() {
        return sensitive;
    }

    public void setSensitive(boolean sensitive) {
        this.sensitive = sensitive;
    }

    public String getSpoilerText() {
        return spoilerText;
    }

    public void setSpoilerText(String spoilerText) {
        this.spoilerText = spoilerText;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Attachment[] getMediaAttachments() {
        return mediaAttachments;
    }

    public void setMediaAttachments(Attachment[] mediaAttachments) {
        this.mediaAttachments = mediaAttachments;
    }

    public Mention[] getMentions() {
        return mentions;
    }

    public void setMentions(Mention[] mentions) {
        this.mentions = mentions;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

}
