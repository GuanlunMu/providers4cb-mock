package org.caringbridge.providers.controllers;


import javax.ws.rs.Path;
import org.caringbridge.providers.model.Funding;
import org.caringbridge.providers.model.Provider;
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
	 * The controller that handle the GET request for Provider information.
	 * 
	 * @param type
	 *            the type of the provider.
	 * @return the Provider information.
	 */

	@ApiOperation(value = "/{type}", notes = "Getting Provider information based on type", produces = "application/json", httpMethod = "GET")
	@ApiResponse(code = 404, message = "No Provider Found")
	@RequestMapping(path = "/{type}", method = RequestMethod.GET)
	public Provider getProvider(
			@ApiParam(name = "type", value = "type of the provider", required = true) @PathVariable("type") final String type) {
		return mockService.getProviderByType(type);

	}

	/**
	 * The controller for handling the mock-data request.
	 *
	 * @param providerId
	 *            the provider id to identify the funding.
	 * @return The Funding object
	 */
	@ApiOperation(value = "/{type}/funding/{provider_id}", notes = "Getting FundingDetail based on provider id", produces = "application/json", httpMethod = "GET")
	@ApiResponse(code = 404, message = "No Funding Found")
	@RequestMapping(path = "/{type}/funding/{provider_id}", method = RequestMethod.GET)
	public Funding getFunding(
			@ApiParam(name = "provider_id", value = "identifier of the campaign", required = true) @PathVariable("provider_id") final String providerId) {
		return mockService.getFundingByProviderId(providerId);
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
