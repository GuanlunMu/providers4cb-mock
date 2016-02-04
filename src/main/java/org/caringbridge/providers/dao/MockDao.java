package org.caringbridge.providers.dao;

import org.caringbridge.providers.model.Funding;
import org.caringbridge.providers.model.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * The DAO for getting Funding based on provider ID.
 *
 * @author guanlun.mu
 *
 */
@Repository
public class MockDao {
	
	/**
	 * The logger that will serve the logging for all DAO-related
	 * information.
	 */
	private static final Logger LOG = LoggerFactory.getLogger("Mock Dao");

	/**
	 * @return the log
	 */
	public static Logger getLog() {
		return LOG;
	}

	/**
	 * The upper bound for randomly generated value of goal.
	 */
	public static final double GOAL_UPPER_BOUND = 10000;

	/**
	 * The upper bound for randomly generated value of contribution_count.
	 */
	public static final int CONTRIBUTION_COUNT_UPPER_BOUND = 100;

	/**
	 * The type of the Provider, in this case, always be MOCK.
	 */
	public static final String TYPE = "MOCK PROVIDER";

	/**
	 * The home page url for the Provider.
	 */
	public static final String URL = "http://mockprovider.com";

	/**
	 * The description of the Provider.
	 */
	public static final String DESCRIPTION = "This is a mock provider service generating fake Funding";

	/**
	 * Returning the Funding based on provider_id, in this case, it will only
	 * return randomly generated Funding.
	 *
	 * @param providerId
	 *            the identifier to identify the campaign
	 * @return Funding that provided by type "mock" on providerId
	 */
	public Funding getFundingByProviderId(final String providerId) {
		getLog().info("Generating random value for Funding......");
		Funding result = new Funding(GOAL_UPPER_BOUND, CONTRIBUTION_COUNT_UPPER_BOUND);
		result.setProviderId(providerId);
		result.setUrl(URL);
		getLog().info("Returning the Funding......");
		return result;

	}

	/**
	 * Returning the Provider based on type.
	 * 
	 * @param type
	 *            type of the provider.
	 * @return Provider information.
	 */

	public Provider getProviderInfo(){
		getLog().info("Generating provider information......");
		Provider result = new Provider();
		result.setName(TYPE);
		result.setUrl(URL);
		result.setDescription(DESCRIPTION);
		getLog().info("Returning the provider information......");
		return result;
	}
}
