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
	 * @param providerId
	 *            the provider id to identify the campaign, hence the funding details
	 * @return The FundingDetail object
	 */
	@Path("/{id}")
	@ApiOperation(value = "Getting FundingDetail based on provider id", notes = "Getting FundingDetail based on provider id", produces = "application/json", httpMethod = "GET")
	@ApiResponse(code = 404, message = "No Funding Detail Found")
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public FundingDetail getFundingDetail(
			@ApiParam(name = "provider_id", value = "identifier of the campaign", required = true) @PathVariable("id") final String providerId) {
		return mockService.getFundingDetailById(providerId);
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
