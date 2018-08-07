package com.springboot.feign.rest;

import org.hamcrest.core.Is;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@AutoConfigureStubRunner(ids = {"com.springboot.cloud:producer:+:stubs:8080"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ClassControllerTest {

    //@Autowired
    private MockMvc mvc;

    //@Test
    public void testMethod() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/classes").param("name", "zhangsan"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code", Is.is("000000")));
    }
}