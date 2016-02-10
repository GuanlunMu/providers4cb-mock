package org.caringbridge.providers.services;

import org.caringbridge.common.services.rep.FundingDetails;
import org.caringbridge.providers.dao.MockDao;
import org.caringbridge.providers.model.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The service layer to serve the controller.
 *
 * @author guanlun.mu
 *
 */
@Service
public class MockService {
	
	/**
	 * The logger that will serve the logging for all service-related
	 * information.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(MockService.class);

	/**
	 * @return the log
	 */
	public static Logger getLog() {
		return LOG;
	}

	/**
	 * The MockDao is used for accessing the wanted FundingDetails.
	 */
	@Autowired
	private MockDao mockDao;

	/**
	 * @return the mockDao
	 */
	public MockDao getMockDao() {
		return mockDao;
	}

	/**
	 * @param mockDao
	 *            the mockDao to set
	 */
	public void setMockDao(final MockDao mockDao) {
		this.mockDao = mockDao;
	}

	/**
	 * Return FundingDetails based on the provider id.
	 *
	 * @param providerId
	 *            the provider id used to identify the FundingDetails
	 * @return the FundingDetails based on the provider id
	 */
	public FundingDetails getFundingDetailsByProviderId(final String providerId) {
		getLog().info("Calling mock DAO to get FundingDetails based on provider id " + providerId + "......");
		return mockDao.getFundingDetailsByProviderId(providerId);

	}

	/**
	 * Return Provider information based on provider type.
	 * 
	 * @param type
	 *            type of the provider.
	 * @return the Provider of the type.
	 */

	public Provider getProviderInfo() {
		getLog().info("Calling mock DAO to get provider information......");
		return mockDao.getProviderInfo();
	}

}
