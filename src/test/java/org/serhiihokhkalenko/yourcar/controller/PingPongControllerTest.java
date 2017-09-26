package org.serhiihokhkalenko.yourcar.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.serhiihokhkalenko.yourcar.Config;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = Config.class)
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PingPongControllerTest {

    private PingPongController pingPongController;

    private MockMvc mockMvc;

    @BeforeAll
    private void init() {
        pingPongController = new PingPongController();

        mockMvc = MockMvcBuilders.standaloneSetup(pingPongController).build();
    }

    @Test
    void ping() throws Exception {
        mockMvc.perform(get("/ping"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(result -> result.equals("pong"));
    }

    @Test
    void badUrl() throws Exception {
        mockMvc.perform(get("/badurl"))
                .andExpect(status().isNotFound());
    }

}