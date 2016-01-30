import static org.junit.Assert.*;

import org.caringbridge.providers.CbMockProviderApplication;
import org.caringbridge.providers.dao.MockDao;
import org.caringbridge.providers.model.Campaign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CbMockProviderApplication.class)
public class MockDaoTest {

    @Autowired
    private MockDao tester;

    private final String ID = "49V843F";

    /**
     * Test whether goal and contributon_count are smaller than goal's upper
     * bound and contribution_count's upper bound respectively,also test whether
     * contribution_total smaller than goal
     */
    @Test
    public void campaignReturnedShouldHaveCorrectNumber() {
	Campaign c = tester.getCampaignById(ID);
	assertTrue(c.getContributionsCount() < 100);
	assertTrue(c.getGoal() < 10000);
	assertTrue(c.getContributionsTotal() < c.getGoal());
    }

    @Test
    public void campaignReturnedShouldHaveCorrectId() {
	Campaign c = tester.getCampaignById(ID);
	assertEquals(ID, c.getId());
    }

    @Test
    public void campaignReturnedShouldHaveOtherFieldsAsNull() {
	Campaign c = tester.getCampaignById(ID);
	assertTrue(c.getCampaingSiteUrl() == null);
	assertTrue(c.getType() == null);
    }

}
