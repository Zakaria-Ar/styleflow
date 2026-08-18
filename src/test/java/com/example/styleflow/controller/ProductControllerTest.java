package com.example.styleflow.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc; //the tool to send fake HTTP requests

    @Test
    void shouldReturn404ForMissingProduct() throws Exception {
        mockMvc.perform(get("/api/products/999"))     // send GET
                .andExpect(status().isNotFound());     // assert 404
    }

    @Test
    void shouldReturn201ForCreatingProduct() throws Exception {
        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Shirt\",\"price\":200,\"stockQuantity\":5}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Shirt"))    // assert the JSON body
                .andExpect(jsonPath("$.id").exists());           // id was generated
    }

    @Test
    void shouldReturn400ForBadRequest() throws Exception {
        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"price\":200}"))
                .andExpect(status().isBadRequest());
    }
}
