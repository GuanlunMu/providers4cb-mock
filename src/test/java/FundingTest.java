import static org.junit.Assert.assertTrue;

import org.caringbridge.providers.model.Campaign;
import org.junit.Test;

public class FundingTest {

    @Test
    public void randomConstructorShouldSetProperFields() {
	Campaign tester = new Campaign(1000, 10);
	assertTrue("Goal should be smaller than 1000", tester.getGoal() < 1000);
	assertTrue("contribution_count should be smaller than 10", tester.getContributionsCount() < 10);
    }

}
