package mastodon4j.internal;

import com.google.inject.Provider;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import java.util.function.Supplier;
import mastodon4j.Mastodon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hecateball
 */
class _PropertiesProvider implements Provider<Properties>, Supplier<Properties> {

    private static final Logger LOGGER = LoggerFactory.getLogger(_PropertiesProvider.class);
    private static final Properties PROPERTIES = new Properties();
    private static final Collection<String> PROPERTIES_FILES
            = Arrays.asList("mastodon4j.properties", "mastodon4j.net.properties");

    static {
        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
                File file = path.toFile();
                if (file.isFile() && PROPERTIES_FILES.contains(file.getName())) {
                    try (InputStream inputStream = Files.newInputStream(path, StandardOpenOption.READ)) {
                        PROPERTIES.load(inputStream);
                        LOGGER.info("Loaded properties:\t{}", file.getName());
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        };
        try {
            URL mastodonLocation = Mastodon.class.getProtectionDomain().getCodeSource().getLocation();
            Files.walkFileTree(Paths.get(mastodonLocation.getPath()), visitor);
            URL location = Thread.currentThread().getContextClassLoader().getResource(".");
            Files.walkFileTree(Paths.get(location.getPath()), visitor);
        } catch (IOException exception) {
            LOGGER.warn("Exception while loading properties", exception);
        }
        PROPERTIES.forEach((key, value) -> LOGGER.debug("{}: {}", key, value));

    }

    @Override
    public Properties get() {
        return PROPERTIES;
    }

}
