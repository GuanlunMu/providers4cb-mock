import static org.junit.Assert.*;

import org.caringbridge.providers.CbMockProviderApplication;
import org.caringbridge.providers.dao.MockDao;
import org.caringbridge.providers.model.Campaign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CbMockProviderApplication.class)
@WebAppConfiguration
public class MockDaoTest {

    @Autowired
    private MockDao tester;

    private final String PROVIDER_ID = "49V843F";

    /**
     * Test whether goal and contributon_count are smaller than goal's upper
     * bound and contribution_count's upper bound respectively,also test whether
     * contribution_total smaller than goal
     */
    @Test
    public void CampaignReturnedShouldHaveCorrectNumber() {
	Campaign f = tester.getCampaignByProviderId(PROVIDER_ID);
	assertTrue(f.getContributionsCount() < 100);
	assertTrue(f.getGoal() < 10000);
	assertTrue(f.getContributionsTotal() < f.getGoal());
    }

    @Test
    public void CampaignReturnedShouldHaveCorrectId() {
	Campaign f = tester.getCampaignByProviderId(PROVIDER_ID);
	assertEquals(PROVIDER_ID, f.getProviderId());
    }

}
