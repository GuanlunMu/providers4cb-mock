package org.caringbridge.providers.model;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The object that will finally be parsed as json returned from this
 * mock-provider microservice.
 *
 * @author guanlun.mu
 *
 */
public class Funding {

	/**
	 * Default constructor.
	 */
	public Funding() {
		super();
	}

	/**
	 * The constructor used for generate a fake Funding with random data.
	 *
	 * @param goalBound
	 *            the upper bound for the random goal number
	 * @param countBound
	 *            the upper bound for the random contribution_count
	 */
	public Funding(final double goalBound, final int countBound) {
		DecimalFormat df = new DecimalFormat("0.00");
		double goalRaw = ThreadLocalRandom.current().nextDouble(goalBound);
		this.goal = format(goalRaw, df);

		double conTotalRaw = ThreadLocalRandom.current().nextDouble(this.goal);
		this.contributionsTotal = format(conTotalRaw, df);

		this.contributionsCount = ThreadLocalRandom.current().nextInt(countBound);

	}


	/**
	 * The provider id used to identify the Funding.
	 */
	@JsonProperty(value = "provider_id", required = true)
	private String providerId;

	
	/**
	 * The targeted amount for the campaign. This amount could be less than the
	 * total contributions if the goal was exceeded.
	 */
	@JsonProperty(value = "goal", required = true)
	private double goal;

	/**
	 * The total amount of contributions.
	 */
	@JsonProperty(value = "contributions_total", required = true)
	private double contributionsTotal;

	/**
	 * The total number of contributions, likely represents the number of
	 * contributors.
	 */
	@JsonProperty(value = "contributions_count", required = true)
	private int contributionsCount;

	/**
	 * The url used to retrieve the fundingdetail.
	 */
	@JsonProperty(value = "url", required = true)
	private String url;
	
	/**
	 * @return the siteId
	 */
	public String getProviderId() {
		return providerId;
	}

	/**
	 * @param providerId
	 *            the providerId to set
	 */
	public void setProviderId(final String providerId) {
		this.providerId = providerId;
	}


	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * @return the goal
	 */
	public double getGoal() {
		return goal;
	}

	/**
	 * @param goal
	 *            the goal to set
	 */
	public void setGoal(final double goal) {
		this.goal = goal;
	}

	/**
	 * @return the contributionsTotal
	 */
	public double getContributionsTotal() {
		return contributionsTotal;
	}

	/**
	 * @param contributionsTotal
	 *            the contributionsTotal to set
	 */
	public void setContributionsTotal(final double contributionsTotal) {
		this.contributionsTotal = contributionsTotal;
	}

	/**
	 * @return the contributionsCount
	 */
	public int getContributionsCount() {
		return contributionsCount;
	}

	/**
	 * @param contributionsCount
	 *            the contributionsCount to set
	 */
	public void setContributionsCount(final int contributionsCount) {
		this.contributionsCount = contributionsCount;
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
