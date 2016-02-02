package org.caringbridge.providers.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is the model for displaying the Provider information.
 * 
 * @author guanlunmu
 *
 */

public class Provider {

	/**
	 * Name of the provider.
	 */
	@JsonProperty(value = "name", required = true)
	private String name;

	/**
	 * url of the provider homepage.
	 */
	@JsonProperty(value = "url", required = true)
	private String url;

	/**
	 * The short description of this provider.
	 */
	@JsonProperty(value = "description", required = true)
	private String description;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the url of the homepage.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the homepage url to set.
	 */
	public void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

}
