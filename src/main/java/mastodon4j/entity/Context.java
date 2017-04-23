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
public class Context implements Serializable {

    private static final long serialVersionUID = -2345497315848692375L;
    @XmlElement(name = "statuses")
    private Status[] statuses;
    @XmlElement(name = "descendants")
    private Status[] descendants;

    public Status[] getStatuses() {
        return statuses;
    }

    public void setStatuses(Status[] statuses) {
        this.statuses = statuses;
    }

    public Status[] getDescendants() {
        return descendants;
    }

    public void setDescendants(Status[] descendants) {
        this.descendants = descendants;
    }

}
