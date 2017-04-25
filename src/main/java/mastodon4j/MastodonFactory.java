package mastodon4j;

import com.google.inject.Guice;
import mastodon4j.internal.__InternalModule;

/**
 *
 * @author hecateball
 */
public final class MastodonFactory {

    private MastodonFactory() {
    }

    public static Mastodon getInstance() {
        return Guice.createInjector(new __InternalModule())
                .getInstance(Mastodon.class);
    }

}
