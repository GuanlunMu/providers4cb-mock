package org.caringbridge.providers.model;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * The model for the Campaign object.
 *
 * @author guanlun.mu
 *
 */

@ApiModel(value = "Campaign", description = "Campaign that show the information about a specific campaign")
public class Campaign {

	/**
	 * Default constructor for Campaign.
	 */
	public Campaign() {
		super();
	}

	/**
	 * The constructor used for generate a random Campaign.
	 *
	 * @param goalBound
	 *            the upperbound for the random goal number
	 * @param countBound
	 *            the upperbound for the random contribution_count
	 */
	public Campaign(final double goalBound, final int countBound) {
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
	@ApiModelProperty(value = "id for this campaign", required = true)
	private String id;


	/**
	 * The type of campaign ran for a site. This will identify the type of
	 * provider partner for the object,
	 */
	@JsonProperty(value = "type", required = true)
	@ApiModelProperty(value = "type of the campaign provider", required = true)
	private String type;

	/**
	 * The targeted amount for the campaign. This amount could be less than the
	 * total contributions if the goal was exceeded.
	 */
	@JsonProperty(value = "goal", required = false)
	@ApiModelProperty(value = "goal of the campaign", required = true)
	private Double goal;

	/**
	 * The total amount of contributions.
	 */
	@JsonProperty(value = "contributions_total", required = false)
	@ApiModelProperty(value = "amount of money that has been collected", required = true)
	private Double contributionsTotal;

	/**
	 * The total number of contributions, likely represents the number of
	 * contributors.
	 */
	@JsonProperty(value = "contributions_count", required = false)
	@ApiModelProperty(value = "amount of person who contributed", required = true)
	private int contributionsCount;

	/**
	 * The url to the web site for viewing and managing the campaign.
	 */
	@JsonProperty(value = "campaign_site_url", required = false)
	@ApiModelProperty(value = "the site url that this campaign is on", required = true)
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
	public void setId(final String id) {
		this.id = id;
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
	public void setType(final String type) {
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
	public void setGoal(final Double goal) {
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
	public void setContributionsTotal(final double contributionsTotal) {
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
	public void setContributionsCount(final int contributionsCount) {
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
	public void setCampaingSiteUrl(final String campaingSiteUrl) {
		this.campaingSiteUrl = campaingSiteUrl;
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
