package it.softwareindustriale.devopsapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmcv.test.autoconfigure.AutoconfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
class DevopsAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mvc;

	@Test
	void infoMostraIlNomeDellApp() throws Exception{
		mvc.perform(get("/info"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.app.name").value("devops-app"));
	}

}
