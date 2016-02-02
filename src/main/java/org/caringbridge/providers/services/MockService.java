package org.caringbridge.providers.services;

import org.caringbridge.providers.dao.MockDao;
import org.caringbridge.providers.model.Funding;
import org.caringbridge.providers.model.Provider;
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
	 * The MockDao is used for accessing the wanted campaign.
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
	 * Return Funding based on the provider id.
	 *
	 * @param providerId
	 *            the provider id used to identify the Funding
	 * @return the Funding based on the provider id
	 */
	public Funding getFundingByProviderId(final String providerId) {
		return mockDao.getFundingByProviderId(providerId);

	}

	/**
	 * Return Provider information based on provider type.
	 * 
	 * @param type
	 *            type of the provider.
	 * @return the Provider of the type.
	 */

	public Provider getProviderInfo() {
		return mockDao.getProviderInfo();
	}

}
