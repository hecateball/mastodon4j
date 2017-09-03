package mastodon4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.stream.Stream;
import mastodon4j.internal._Mastodon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hecateball
 */
public final class MastodonFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(MastodonFactory.class);
    private static final String MASTODON4J_PROPERTIES = "mastodon4j.properties";

    private MastodonFactory() {
    }

    public static Mastodon getInstance() {
        Properties properties = new Properties();
        File file = new File("." + File.separatorChar + MASTODON4J_PROPERTIES);
        if (file.exists() && file.isFile()) {
            try (InputStream stream = new FileInputStream(file)) {
                properties.load(stream);
            } catch (IOException exception) {
                LOGGER.trace("Exception while loading properties", exception);
            }
        }
        Stream.of("/", "/WEB-INF/", "WEB-INF/")
                .forEach(path -> {
                    try (InputStream stream = MastodonFactory.class.getResourceAsStream(path + MASTODON4J_PROPERTIES);) {
                        if (stream == null) {
                            return;
                        }
                        properties.load(stream);
                    } catch (IOException exception) {
                        LOGGER.trace("Exception while loading properties", exception);
                    }
                });
        properties.forEach((key, value) -> LOGGER.trace("{}: {}", key, value));
        return MastodonFactory.getInstance(properties);
    }

    public static Mastodon getInstance(Properties properties) {
        return MastodonFactory.getInstance(properties.getProperty("mastodon4j.uri"), properties.getProperty("mastodon4j.accessToken"));
    }

    public static Mastodon getInstance(String uri, String accessToken) {
        return new _Mastodon(uri, accessToken);
    }

}
