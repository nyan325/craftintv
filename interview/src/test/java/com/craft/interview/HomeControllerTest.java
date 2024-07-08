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

import com.craft.interview.controller.HomeController;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {

    @LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

    @Autowired
    private HomeController homeController;

    @Test
    void testHomeController() {
        String hc = homeController.getHomeMethod();
        assertThat(homeController).isNotNull();
        assert(hc.indexOf("Hello")>0);

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Hello and Welcome");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/craft", String.class)).contains("Craft");
    }

}
