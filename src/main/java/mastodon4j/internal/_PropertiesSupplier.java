package mastodon4j.internal;

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
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hecateball
 */
final class _PropertiesSupplier implements Supplier<Properties> {

    private static final Logger LOGGER = LoggerFactory.getLogger(_PropertiesSupplier.class);
    private static final Properties PROPERTIES = new Properties();
    private static final Collection<String> PROPERTIES_FILES = Arrays.asList("mastodon4j.properties");

    static {
        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
                LOGGER.trace("Properties root path: {}", path.toString());
                File file = path.toFile();
                if (file.isFile() && PROPERTIES_FILES.contains(file.getName())) {
                    try (InputStream inputStream = Files.newInputStream(path, StandardOpenOption.READ)) {
                        PROPERTIES.load(inputStream);
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
        PROPERTIES.forEach((key, value) -> LOGGER.trace("{}: {}", key, value));
    }

    @Override
    public Properties get() {
        return PROPERTIES;
    }

}
