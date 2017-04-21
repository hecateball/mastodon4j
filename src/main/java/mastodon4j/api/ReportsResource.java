package mastodon4j.api;

import mastodon4j.entity.Report;

/**
 *
 * @author hecateball
 */
public interface ReportsResource {

    /**
     * Fetching a user's reports.
     *
     * @return a list of Reports made by the authenticated user
     */
    public Report[] getReports();

    /**
     * Reporting a user.
     *
     * @param accountId
     * @param statusIds
     * @param comment
     * @return the finished Report
     */
    public Report postReport(long accountId, long[] statusIds, String comment);
}
