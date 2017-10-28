package mastodon4j.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hecateball
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Status implements Serializable {

    private static final long serialVersionUID = -5976946573675678719L;
    @XmlElement(name = "id")
    private long id;
    @XmlElement(name = "uri")
    private String uri;
    @XmlElement(name = "url")
    private String url;
    @XmlElement(name = "account")
    private Account account;
    @XmlElement(name = "in_reply_to_id")
    private Long inReplyToId;
    @XmlElement(name = "in_reply_to_account_id")
    private Long inReplyToAccountId;
    @XmlElement(name = "reblog")
    private Status reblog;
    @XmlElement(name = "content")
    private String content;
    @XmlElement(name = "created_at")
    private String createdAt;
    @XmlElement(name = "reblogs_count")
    private long reblogsCount;
    @XmlElement(name = "favourites_count")
    private long favouritesCount;
    @XmlElement(name = "reblogged")
    private boolean reblogged;
    @XmlElement(name = "favourited")
    private boolean favourited;
    @XmlElement(name = "sensitive")
    private boolean sensitive;
    @XmlElement(name = "spoiler_text")
    private String spoilerText;
    @XmlElement(name = "visibility")
    private String visibility;
    @XmlElement(name = "media_attachments")
    private Attachment[] mediaAttachments;
    @XmlElement(name = "mentions")
    private Mention[] mentions;
    @XmlElement(name = "tags")
    private Tag[] tags;
    @XmlElement(name = "application")
    private Application application;

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

    public Long getInReplyToId() {
        return inReplyToId;
    }

    public void setInReplyToId(Long inReplyToId) {
        this.inReplyToId = inReplyToId;
    }

    public Long getInReplyToAccountId() {
        return inReplyToAccountId;
    }

    public void setInReplyToAccountId(Long inReplyToAccountId) {
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
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

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

}
