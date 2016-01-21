package org.caringbridge.providers.controllers;

import org.caringbridge.providers.model.Campaign;
import org.caringbridge.providers.model.FundingDetail;
import org.caringbridge.providers.services.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller that will handle the request based on different url
 *
 * @author guanlun.mu
 *
 */
@RestController
@RequestMapping(path = "/provider")
public class MockController {

    @Autowired
    private MockService mockService;
    /**
     * The controller for handling the mock-data request
     *
     * @param site_id
     *            the site id to identify the site on Caring Bridge
     * @return The FundingDetail object
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public FundingDetail getFundingDetail(@PathVariable("id") String siteId) {
	return mockService.getFundingDetailBySite(siteId);
    }
    /**
     * @return the mockService
     */
    public MockService getMockService() {
        return mockService;
    }
    /**
     * @param mockService the mockService to set
     */
    public void setMockService(MockService mockService) {
        this.mockService = mockService;
    }

}
