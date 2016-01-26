package org.caringbridge.providers.controllers;

import javax.ws.rs.Path;

import org.caringbridge.providers.model.FundingDetail;
import org.caringbridge.providers.services.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;

/**
 * The controller that will handle the request based on different url.
 *
 * @author guanlun.mu
 *
 */
@Path("/provider")
@Api(basePath = "/provider", value = "/provider", description = "The controller that handle the request on /provider and return corresponding details")
@RestController
@RequestMapping(path = "/provider")
public class MockController {

	/**
	 * The mockservice that will return FundingDetail.
	 */
	@Autowired
	private MockService mockService;

	/**
	 * The controller for handling the mock-data request.
	 *
	 * @param siteId
	 *            the site id to identify the site on Caring Bridge
	 * @return The FundingDetail object
	 */
	@Path("/{id}")
	@ApiOperation(value = "Getting FundingDe-tail on a certain site", notes = "Getting FundingDetail on a certain site", produces = "application/json", httpMethod = "GET")
	@ApiResponse(code = 404, message = "No Funding Detail on this Site")
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public FundingDetail getFundingDetail(
			@ApiParam(name = "site_id", value = "site id of the site", required = true) @PathVariable("id") final String siteId) {
		return mockService.getFundingDetailBySite(siteId);
	}

	/**
	 * @return the mockService
	 */
	public MockService getMockService() {
		return mockService;
	}

	/**
	 * @param mockService
	 *            the mockService to set
	 */
	public void setMockService(final MockService mockService) {
		this.mockService = mockService;
	}

}
