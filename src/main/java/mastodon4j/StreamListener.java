package mastodon4j;

import mastodon4j.entity.Notification;
import mastodon4j.entity.Status;
import org.glassfish.jersey.media.sse.EventListener;
import org.glassfish.jersey.media.sse.InboundEvent;

/**
 *
 * @author hecateball
 */
public abstract class StreamListener implements EventListener {

    public abstract void onUpdate(Status status);

    public abstract void onNotification(Notification notification);

    public abstract void onDelete(long id);

    @Override
    public void onEvent(InboundEvent ie) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
