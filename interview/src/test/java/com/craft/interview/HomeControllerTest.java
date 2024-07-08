package com.craft.interview;

//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.craft.interview.controller.HomeController;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HomeControllerTest {

    @LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

    @Autowired
    private HomeController homeController;

    @Autowired
	private MockMvc mockMvc;

    @Test
    void testHomeController() throws Exception{
        //String hc = homeController.getHomeMethod();
        //ResponseEntity<String> responseEntity = homeController.getHomeMethod();

        assertThat(homeController).isNotNull();
        //System.out.println(" ======= " + (responseEntity.hasBody() ? responseEntity. : "Empty"));
        //assert(responseEntity.getBody().toString().indexOf("Hello")>0);

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Hello and Welcome");
        //assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/craft", String.class)).contains("Craft");

        this.mockMvc.perform(get("/craft")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Craft-Hello")));
    }

}
