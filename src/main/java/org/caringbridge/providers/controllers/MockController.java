package org.caringbridge.providers.controllers;

import org.caringbridge.providers.model.FundingDetail;
import org.caringbridge.providers.services.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller that will handle the request based on different url.
 *
 * @author guanlun.mu
 *
 */
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
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public FundingDetail getFundingDetail(@PathVariable("id") final String siteId) {
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
