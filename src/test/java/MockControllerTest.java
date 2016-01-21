import org.caringbridge.providers.CbMockProviderApplication;
import org.caringbridge.providers.controllers.MockController;
import org.caringbridge.providers.services.MockService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CbMockProviderApplication.class)
public class MockControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private MockController mc;

    @Before
    public void init(){
	mockMvc = MockMvcBuilders.standaloneSetup(mc).build();
    }

    @Test
    public void controllerShouldReturnRightData() throws Exception{
	String siteId = "49V843F";
	RequestBuilder mockGet = MockMvcRequestBuilders.get("/provider/"+siteId);

	ResultActions response = mockMvc.perform(mockGet);
	response.andDo(MockMvcResultHandlers.print())
	.andExpect(status().is(200))
	.andExpect(content().contentType("application/json;charset=UTF-8"))
	.andExpect(jsonPath("$.site_id").isString())
	.andExpect(jsonPath("$.site_id").value(siteId))
	.andExpect(jsonPath("$.goal").isNumber())
	.andExpect(jsonPath("$.contributions_total").isNumber())
	.andExpect(jsonPath("$.contributions_count").isNumber());
    }

}
