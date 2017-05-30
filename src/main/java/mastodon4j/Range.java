package mastodon4j;

import java.util.Optional;

/**
 *
 * @author hecateball
 */
public final class Range {

    private Optional<Long> maxId;
    private Optional<Long> sinceId;
    private Optional<Long> limit;

    public Range() {
        this.maxId = Optional.empty();
        this.sinceId = Optional.empty();
        this.limit = Optional.empty();
    }

    public Optional<Long> getMaxId() {
        return maxId;
    }

    public void setMaxId(long maxId) {
        this.maxId = Optional.of(maxId);
    }

    public Optional<Long> getSinceId() {
        return sinceId;
    }

    public void setSinceId(long sinceId) {
        this.sinceId = Optional.of(sinceId);
    }

    public Optional<Long> getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = Optional.of(limit);
    }

}
