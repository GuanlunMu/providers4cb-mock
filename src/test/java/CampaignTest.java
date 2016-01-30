import static org.junit.Assert.assertTrue;

import org.caringbridge.providers.model.Funding;
import org.junit.Test;

public class CampaignTest {

    @Test
    public void randomConstructorShouldSetProperFields() {
	Funding tester = new Funding(1000, 10);
	assertTrue("goal should be smaller than 1000", tester.getGoal() < 1000);
	assertTrue("contribution_count should be smaller than 10", tester.getContributionsCount() < 10);
    }

}
