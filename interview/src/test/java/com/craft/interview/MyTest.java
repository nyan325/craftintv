package com.craft.interview;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MyTest {
	@Autowired
	private MockMvc mockMvc;

    //photographers/event/birthdays
	@Test
	void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/photographers/event/birthdays")).andDo(print()).andExpect(status().isOk());
				//.andExpect(content().isOk());
	}
    
}
