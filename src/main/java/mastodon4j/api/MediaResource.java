package mastodon4j.api;

import mastodon4j.entity.Attachment;

/**
 *
 * @author hecateball
 */
public interface MediaResource {

    /**
     * Uploading a media attachment.
     *
     * @param file media to be uploaded
     * @return an Attachment that can be used when creating a status
     */
    public Attachment postMedia(String file);
}
