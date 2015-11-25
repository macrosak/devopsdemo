package com.tado
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.web.context.WebApplicationContext

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = DevOpsDemoApplication)
@WebAppConfiguration
public class DevOpsDemoApplicationTests {

   private MockMvc mockMvc

   @Autowired
   private WebApplicationContext webApplicationContext

   @Before
   public void setup() throws Exception {
      mockMvc = webAppContextSetup(webApplicationContext).build()

   }

   @Test
   public void devopsRouteRespondsWithHello() {
      mockMvc.perform(get("/devops"))
         .andExpect(status().isOk())
         .andExpect(MockMvcResultMatchers.content().string("Hello DevOps!"))
   }

}
