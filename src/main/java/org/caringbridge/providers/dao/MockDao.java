package org.caringbridge.providers.dao;

import org.caringbridge.providers.model.Campaign;
import org.springframework.stereotype.Repository;

/**
 * The DAO for getting Campaign based on different criteria.
 *
 * @author guanlun.mu
 *
 */
@Repository
public class MockDao {

    /**
     * The upper bound for randomly generated value of goal.
     */
    public static final double GOAL_UPPER_BOUND = 10000;

    /**
     * The upper bound for randomly generated value of contribution_count.
     */
    public static final int CONTRIBUTION_COUNT_UPPER_BOUND = 100;
    /**
     * Returning the Campaign based on site_id, in this case, it will only
     * return randomly generated Campaign.
     *
     * @param siteId
     *            the identifier to identify the site
     * @return Campaign that provided by type "mock" on siteId
     */
    public Campaign getCampaignBySite(final String siteId) {
	Campaign result = new Campaign(GOAL_UPPER_BOUND, CONTRIBUTION_COUNT_UPPER_BOUND);
	result.setSiteId(siteId);
	return result;

    }
}
