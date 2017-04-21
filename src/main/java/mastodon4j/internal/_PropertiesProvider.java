package mastodon4j.internal;

import com.google.inject.Provider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
        URL mastodonLocation = Mastodon.class.getProtectionDomain().getCodeSource().getLocation();
        _PropertiesProvider.loadProperties(new File(mastodonLocation.getFile()).listFiles());
        URL location = Thread.currentThread().getContextClassLoader().getResource(".");
        _PropertiesProvider.loadProperties(new File(location.getFile()).listFiles());
    }

    private static void loadProperties(File[] files) {
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                loadProperties(file.listFiles());
            }
            if (file.isFile() && PROPERTIES_FILES.contains(file.getName())) {
                try (InputStream inputStream = new FileInputStream(file)) {
                    PROPERTIES.load(inputStream);
                    LOGGER.info("Loaded properties:\t{}", file.getName());
                } catch (IOException exception) {
                    LOGGER.error(exception.getMessage(), exception);
                }
            }
        }
    }

    @Override
    public Properties get() {
        return PROPERTIES;
    }

}
