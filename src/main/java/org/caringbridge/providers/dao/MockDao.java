package org.caringbridge.providers.dao;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import org.caringbridge.providers.model.Campaign;
import org.springframework.stereotype.Repository;

/**
 * The DAO for getting Campaign based on different criteria
 *
 * @author guanlun.mu
 *
 */
@Repository
public class MockDao {

    /**
     * Returning the Campaign based on site_id, in this case, it will only
     * return randomly generated Campaign
     *
     * @param siteId
     *            the identifier to identify the site
     * @return Campaign that provided by type "mock" on siteId
     */
    public Campaign getCampaignBySite(String siteId) {
	Campaign result = new Campaign(10000, 100);
	result.setSiteId(siteId);
	return result;

    }
}
