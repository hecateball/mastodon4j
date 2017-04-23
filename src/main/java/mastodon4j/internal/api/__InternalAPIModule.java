package mastodon4j.internal.api;

import com.google.inject.AbstractModule;
import mastodon4j.api.AppsResource;
import mastodon4j.api.OauthResource;
import mastodon4j.api.StreamingResource;

/**
 *
 * @author hecateball
 */
public class __InternalAPIModule extends AbstractModule {

    @Override
    protected void configure() {
        // API Resources
        bind(AppsResource.class).to(_AppsResource.class);
        bind(OauthResource.class).to(_OauthResource.class);
        bind(StreamingResource.class).to(_StreamingResource.class);
    }

}
