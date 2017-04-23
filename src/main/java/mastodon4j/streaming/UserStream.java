package mastodon4j.streaming;

import org.glassfish.jersey.media.sse.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hecateball
 */
public class UserStream implements AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserStream.class);
    private final EventSource eventSource;

    public UserStream(EventSource eventSource) {
        this.eventSource = eventSource;
    }

    public void register(UserStreamListener listener) {
        this.eventSource.register(event -> {
            LOGGER.debug("{}: {}", event.getName(), event.readData());
            switch (event.getName()) {
                case "update":
                    //this.listeners.forEach(listener -> listener.onDelete(Long.parseLong(event.readData())));
                    break;
                case "notification":
                    //this.listeners.forEach(listener -> listener.onDelete(Long.parseLong(event.readData())));
                    break;
                case "delete":
                    listener.onDelete(event.readData(Long.class));
                    break;
                default:
                    LOGGER.debug("Unexpected event name: {}", event.getName());
            }
        });
    }

    public void open() {
        if (!this.eventSource.isOpen()) {
            this.eventSource.open();
        }

    }

    @Override
    public void close() {
        if (this.eventSource.isOpen()) {
            this.eventSource.close();
        }
    }

}
