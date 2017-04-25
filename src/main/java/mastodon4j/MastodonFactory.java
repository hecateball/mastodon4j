package mastodon4j;

import mastodon4j.internal._Mastodon;

/**
 *
 * @author hecateball
 */
public final class MastodonFactory {

    private MastodonFactory() {
    }

    public static Mastodon getInstance() {
        return new _Mastodon();
    }

}
