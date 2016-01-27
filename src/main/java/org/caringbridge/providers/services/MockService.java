package org.caringbridge.providers.services;

import org.caringbridge.providers.dao.MockDao;
import org.caringbridge.providers.model.Campaign;
import org.caringbridge.providers.model.FundingDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The functonality of ProviderService include: 1. Using the ProviderDao to get
 * the Campaign 2. Transfer from Campaign to FundingDetail
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
	 * Return FundingDetail based on the provider id.
	 *
	 * @param providerId
	 *            the provider id used to identify the campaign, hence the
	 *            funding detail
	 * @return the FundingDetail on the provider of providerId
	 */
	public FundingDetail getFundingDetailById(final String providerId) {
		Campaign c = mockDao.getCampaignById(providerId);
		return new FundingDetail(c);

	}

}
