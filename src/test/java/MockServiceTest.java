import static org.junit.Assert.*;

import org.caringbridge.providers.CbMockProviderApplication;
import org.caringbridge.providers.model.FundingDetail;
import org.caringbridge.providers.services.MockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CbMockProviderApplication.class)
public class MockServiceTest {

    @Autowired
    private MockService ms;

    private final String ID = "49V843F";

    @Test
    public void serviceShouldReturnRightData(){
	FundingDetail tester = ms.getFundingDetailById(ID);
	assertEquals((int)tester.getContributionsCount(),tester.getContributionsCount());
	assertEquals((double)tester.getContributionsTotal(),tester.getContributionsTotal(),0.0);
	assertEquals((double)tester.getGoal(),tester.getGoal(),0.0);
	assertTrue(tester.getContributionsTotal() < tester.getGoal());
    }

}
