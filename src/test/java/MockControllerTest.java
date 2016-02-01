import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.caringbridge.providers.CbMockProviderApplication;
import org.caringbridge.providers.controllers.MockController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CbMockProviderApplication.class)
@WebAppConfiguration
public class MockControllerTest {

	private MockMvc mockMvc;

//	@Autowired 
//	private SpringSwaggerConfig springSwaggerConfig;
	
	@Autowired
	private MockController mc;

	private final String PROVIDER_ID = "49V843F";

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(mc).build();
	}

	@Test
	public void controllerShouldReturnRightData() throws Exception {

		RequestBuilder mockGet = MockMvcRequestBuilders.get("/provider/mock/funding/" + PROVIDER_ID);

		ResultActions response = mockMvc.perform(mockGet);
		response.andDo(MockMvcResultHandlers.print()).andExpect(status().is(200))
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.goal").isNumber()).andExpect(jsonPath("$.contributions_total").isNumber())
				.andExpect(jsonPath("$.contributions_count").isNumber());
	}

}
