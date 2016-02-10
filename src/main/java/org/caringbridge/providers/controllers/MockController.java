package org.caringbridge.providers.controllers;

import org.caringbridge.common.services.rep.FundingDetails;
import org.caringbridge.providers.model.Provider;
import org.caringbridge.providers.services.MockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Api(basePath = "/providers", value = "/providers", description = "The controller that handle the request on /provider and return corresponding details")
@RestController
@RequestMapping(path = "/providers")
public class MockController {

	/**
	 * The logger that will serve the logging for all controller-related
	 * information.
	 */

	private static final Logger LOG = LoggerFactory.getLogger("Mock Controllers");

	/**
	 * The mockservice that will return FundingDetails
	 * 
	 * .
	 */
	@Autowired
	private MockService mockService;

	/**
	 * The controller that handle the GET request for Provider information.
	 * 
	 * 
	 * @return the Provider information.
	 */

	@ApiOperation(value = "/mock", notes = "Getting Provider information based of mock provider", produces = "application/json", httpMethod = "GET")
	@ApiResponse(code = 404, message = "No Information Found for this Provider")
	@RequestMapping(path = "/mock", method = RequestMethod.GET)
	public Provider getProvider() {
		getLog().info("Calling mock service to get provider information......");
		return mockService.getProviderInfo();

	}

	/**
	 * The controller for handling the mock-data request.
	 *
	 * @param providerId
	 *            the provider id to identify the FundingDetails.
	 * @return The FundingDetails object
	 */
	@ApiOperation(value = "/mock/campaigns/{provider_id}", notes = "Getting FundingDetails based on provider id", produces = "application/json", httpMethod = "GET")
	@ApiResponse(code = 404, message = "No FundingDetails Found")
	@RequestMapping(path = "/mock/campaigns/{provider_id}", method = RequestMethod.GET)
	public FundingDetails getFundingDetails(
		@ApiParam(name = "provider_id", value = "identifier of the FundingDetails", required = true) @PathVariable("provider_id") final String providerId) {
		getLog().info("Calling mock service to get FundingDetails based on provider id " + providerId);
		return mockService.getFundingDetailsByProviderId(providerId);
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
	
	/**
	 * @return the log
	 */
	public static Logger getLog() {
		return LOG;
	}

}
