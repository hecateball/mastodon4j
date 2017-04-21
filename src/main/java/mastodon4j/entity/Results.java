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
public class Results implements Serializable {

    private static final long serialVersionUID = -2574904438341694323L;
    private Account[] accounts;
    private Status[] statuses;
    private String[] hashtags;

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Status[] getStatuses() {
        return statuses;
    }

    public void setStatuses(Status[] statuses) {
        this.statuses = statuses;
    }

    public String[] getHashtags() {
        return hashtags;
    }

    public void setHashtags(String[] hashtags) {
        this.hashtags = hashtags;
    }

}
