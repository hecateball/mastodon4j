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
public class Relationship implements Serializable {

    private static final long serialVersionUID = -6521826192219144201L;
    @XmlElement(name = "id")
    private long id;
    @XmlElement(name = "following")
    private boolean following;
    @XmlElement(name = "followedBy")
    private boolean followedBy;
    @XmlElement(name = "blocking")
    private boolean blocking;
    @XmlElement(name = "muting")
    private boolean muting;
    @XmlElement(name = "requested")
    private boolean requested;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public boolean isFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(boolean followedBy) {
        this.followedBy = followedBy;
    }

    public boolean isBlocking() {
        return blocking;
    }

    public void setBlocking(boolean blocking) {
        this.blocking = blocking;
    }

    public boolean isMuting() {
        return muting;
    }

    public void setMuting(boolean muting) {
        this.muting = muting;
    }

    public boolean isRequested() {
        return requested;
    }

    public void setRequested(boolean requested) {
        this.requested = requested;
    }

}
