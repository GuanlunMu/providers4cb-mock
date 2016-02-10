package org.caringbridge.providers.dao;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import org.caringbridge.common.services.rep.FundingDetails;
import org.caringbridge.providers.model.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * The DAO for getting FundingDetails based on provider ID.
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
	public static final String DESCRIPTION = "This is a mock provider service generating fake FundingDetails";

	/**
	 * Returning the FundingDetails based on provider_id, in this case, it will only
	 * return randomly generated FundingDetails.
	 *
	 * @param providerId
	 *            the identifier to identify the FundingDetails
	 * @return FundingDetails that provided by type "mock" on providerId
	 */
	public FundingDetails getFundingDetailsByProviderId(final String providerId) {
		getLog().info("Generating random value for FundingDetails......");
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		double goalRaw = ThreadLocalRandom.current().nextDouble(GOAL_UPPER_BOUND);
		double goal = format(goalRaw, df);

		double conTotalRaw = ThreadLocalRandom.current().nextDouble(goal);
		double contributionsTotal = format(conTotalRaw, df);

		int contributionsCount = ThreadLocalRandom.current().nextInt(CONTRIBUTION_COUNT_UPPER_BOUND);
		
		FundingDetails result = new FundingDetails(goal,contributionsTotal,contributionsCount);
//		result.setProviderId(providerId);
		result.setUrl(URL);
		getLog().info("Returning the FundingDetails......");
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
	
	/**
	 * A help method to round the double value to two significant value.
	 *
	 * @param d
	 *            the double need to be formated
	 * @param df
	 *            the format for this double
	 * @return formatted value
	 */
	private double format(final double d, final DecimalFormat df) {
		return Double.valueOf(df.format(d));
	}
}
