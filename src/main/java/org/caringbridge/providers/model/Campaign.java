package org.caringbridge.providers.model;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The model for the Campaign object
 *
 * @author guanlun.mu
 *
 */

public class Campaign {

    /**
     * Default constructor for Campaign
     */
    public Campaign() {
	super();
    }

    /**
     * The constructor used for generate a random Campaign
     *
     * @param goalBound
     *            the upperbound for the random goal number
     * @param countBound
     *            the upperbound for the random contribution_count
     */
    public Campaign(double goalBound, int countBound) {
	DecimalFormat df = new DecimalFormat("0.00");
	double goalRaw = ThreadLocalRandom.current().nextDouble(goalBound);
	this.goal = format(goalRaw, df);

	double conTotalRaw = ThreadLocalRandom.current().nextDouble(this.goal);
	this.contributionsTotal = format(conTotalRaw, df);

	this.contributionsCount = ThreadLocalRandom.current().nextInt(countBound);


    }

    /**
     * The internal identification number for this campaign.
     */
    @JsonProperty(value = "id", required = true)
    private String id;

    /**
     * The id of the site that is linked to a founding campaign.
     */
    @JsonProperty(value = "site_id", required = true)
    private String siteId;

    /**
     * The type of campaign ran for a site. This will identify the type of
     * provider partner for the object,
     */
    @JsonProperty(value = "type", required = true)
    private String type;

    /**
     * The targeted amount for the campaign. This amount could be less than the
     * total contributions if the goal was exceeded.
     */
    @JsonProperty(value = "goal", required = false)
    private Double goal;

    /**
     * The total amount of contributions.
     */
    @JsonProperty(value = "contributions_total", required = false)
    private Double contributionsTotal;

    /**
     * The total number of contributions, likely represents the number of
     * contributors.
     */
    @JsonProperty(value = "contributions_count", required = false)
    private int contributionsCount;

    /**
     * The url to the web site for viewing and managing the campaign.
     */
    @JsonProperty(value = "campaign_site_url", required = false)
    private String campaingSiteUrl;

    /**
     * @return the id.
     */
    public String getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set.
     */
    public void setId(String id) {
	this.id = id;
    }

    /**
     * @return the siteId.
     */
    public String getSiteId() {
	return siteId;
    }

    /**
     * @param siteId
     *            the siteId to set.
     */
    public void setSiteId(String siteId) {
	this.siteId = siteId;
    }

    /**
     * @return the type.
     */
    public String getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set.
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * @return the goal.
     */
    public Double getGoal() {
	return goal;
    }

    /**
     * @param goal
     *            the goal to set.
     */
    public void setGoal(Double goal) {
	this.goal = goal;
    }

    /**
     * @return the contributionsTotal.
     */
    public Double getContributionsTotal() {
	return contributionsTotal;
    }

    /**
     * @param contributionsTotal
     *            the contributionsTotal to set.
     */
    public void setContributionsTotal(Double contributionsTotal) {
	this.contributionsTotal = contributionsTotal;
    }

    /**
     * @return the contributionsCount.
     */
    public int getContributionsCount() {
	return contributionsCount;
    }

    /**
     * @param contributionsCount
     *            the contributionsCount to set.
     */
    public void setContributionsCount(int contributionsCount) {
	this.contributionsCount = contributionsCount;
    }

    /**
     * @return the campaingSiteUrl.
     */
    public String getCampaingSiteUrl() {
	return campaingSiteUrl;
    }

    /**
     * @param campaingSiteUrl
     *            the campaingSiteUrl to set.
     */
    public void setCampaingSiteUrl(String campaingSiteUrl) {
	this.campaingSiteUrl = campaingSiteUrl;
    }

    private double format(double d, DecimalFormat df) {
	return Double.valueOf(df.format(d));
    }
}
