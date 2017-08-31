package mastodon4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import mastodon4j.internal._Mastodon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hecateball
 */
public final class MastodonFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(MastodonFactory.class);
    private static final Collection<String> PROPERTIES_FILES = Arrays.asList("mastodon4j.properties");

    private MastodonFactory() {
    }

    public static Mastodon getInstance() {
        Properties properties = new Properties();
        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
                LOGGER.trace("Properties root path: {}", path.toString());
                File file = path.toFile();
                if (file.isFile() && PROPERTIES_FILES.contains(file.getName())) {
                    try (InputStream inputStream = Files.newInputStream(path, StandardOpenOption.READ)) {
                        properties.load(inputStream);
                        LOGGER.trace("Loaded properties:\t{}", file.getName());
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        };

        try {
            URL location = Thread.currentThread().getContextClassLoader().getResource(".");
            Files.walkFileTree(Paths.get(location.toURI()), visitor);
        } catch (URISyntaxException | IOException exception) {
            LOGGER.warn("Exception while loading properties", exception);
        }

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
