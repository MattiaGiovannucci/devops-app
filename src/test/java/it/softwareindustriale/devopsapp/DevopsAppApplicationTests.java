package it.softwareindustriale.devopsapp;

import java.beans.Transient;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmcv.test.autoconfigure.AutoconfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class DevopsAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mvc;

	@Test
	void infoMostraIlNomeDellApp() throws Exception{
		mvc.perform(get( uriTemplate-> "/info"))
		.andExpect(status().isOk())
		.andExpect(jsonPath( expression-> "$.app.name").value( expectedValue-> "devops-app"));
	}

}
