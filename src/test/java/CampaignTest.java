import static org.junit.Assert.*;

import org.caringbridge.providers.model.Campaign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

public class CampaignTest {

    @Test
    public void randomConstructorShouldSetProperFields() {
	Campaign tester = new Campaign(1000, 10);
	assertTrue("goal should be smaller than 1000", tester.getGoal() < 1000);
	assertTrue("contribution_count should be smaller than 10", tester.getContributionsCount() < 10);
    }

}
