package mastodon4j.internal;

/**
 *
 * @author hecateball
 */
class _InternalUtility {

    private _InternalUtility() {
    }

    static String getBearerToken(String accessToken) {
        return "Bearer " + accessToken;
    }
}
