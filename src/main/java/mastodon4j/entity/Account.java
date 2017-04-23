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
public class Account implements Serializable {

    private static final long serialVersionUID = 7028160804135739581L;
    @XmlElement(name = "id")
    private long id;
    @XmlElement(name = "username")
    private String userName;
    @XmlElement(name = "acct")
    private String account;
    @XmlElement(name = "display_name")
    private String displayName;
    @XmlElement(name = "locked")
    private boolean locked;
    @XmlElement(name = "created_at")
    private String createdAt;
    @XmlElement(name = "followers_count")
    private long followersCount;
    @XmlElement(name = "following_count")
    private long followingCount;
    @XmlElement(name = "statuses_count")
    private long statusesCount;
    @XmlElement(name = "note")
    private String note;
    @XmlElement(name = "url")
    private String url;
    @XmlElement(name = "avatar")
    private String avatar;
    @XmlElement(name = "avatar_static")
    private String avatarStatic;
    @XmlElement(name = "header")
    private String header;
    @XmlElement(name = "header_static")
    private String headerStatic;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(long followersCount) {
        this.followersCount = followersCount;
    }

    public long getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(long followingCount) {
        this.followingCount = followingCount;
    }

    public long getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(long statusesCount) {
        this.statusesCount = statusesCount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarStatic() {
        return avatarStatic;
    }

    public void setAvatarStatic(String avatarStatic) {
        this.avatarStatic = avatarStatic;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeaderStatic() {
        return headerStatic;
    }

    public void setHeaderStatic(String headerStatic) {
        this.headerStatic = headerStatic;
    }

}
