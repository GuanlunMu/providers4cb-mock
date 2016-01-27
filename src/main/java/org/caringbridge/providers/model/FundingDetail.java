package org.caringbridge.providers.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The object that will finally be parsed as json returned from this
 * mock-provider microservice.
 *
 * @author guanlun.mu
 *
 */
public class FundingDetail {

    /**
     * Default constructor.
     */
    public FundingDetail() {
	super();
    }

    /**
     * Constructor with values for all the fields.
     *
     * @param goal
     *            The double goal of the campaign
     * @param contributionsTotal
     *            The double current total of the contributions
     * @param contributionsCount
     *            The double current number of contributions
     */
    public FundingDetail(final double goal, final double contributionsTotal, final int contributionsCount) {
	this.goal = goal;
	this.contributionsTotal = contributionsTotal;
	this.contributionsCount = contributionsCount;
    }

    /**
     * Constructor for parsing a Campaign instance to a FundingDetail instance.
     *
     * @param c the Campaign that need to parsed
     */
    public FundingDetail(final Campaign c) {
	this.goal = c.getGoal();
	this.contributionsCount = c.getContributionsCount();
	this.contributionsTotal = c.getContributionsTotal();
    }

    /**
     * The site id used to identify the site_id.
     */
    @JsonProperty(value = "site_id", required = true)
    private String siteId;

    /**
     * @return the siteId
     */
    public String getSiteId() {
	return siteId;
    }

    /**
     * @param siteId
     *            the siteId to set
     */
    public void setSiteId(final String siteId) {
	this.siteId = siteId;
    }

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
}
