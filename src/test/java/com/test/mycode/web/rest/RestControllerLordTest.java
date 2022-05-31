package com.test.mycode.web.rest;

import com.test.mycode.MyCodeApplicationTests;
import com.test.mycode.entity.Lord;
import com.test.mycode.entity.Planet;
import com.test.mycode.repository.RepositoryLord;
import com.test.mycode.repository.RepositoryPlanet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RestControllerLordTest extends MyCodeApplicationTests {

    @Autowired
    private RepositoryLord repositoryLord;

    @Autowired
    private RepositoryPlanet repositoryPlanet;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void initDb() {
        repositoryLord.save(Lord.builder().name("Lord").age(1000l).build());
        repositoryLord.save(Lord.builder().name("Test").age(1000l).build());
        repositoryPlanet.save(Planet.builder().name("Mars").build());
    }

    @Test
    void saveLord() throws Exception {

        mockMvc.perform(post("http://localhost:8080/lord/add")
                        .param("name", "Test")
                        .param("age", "20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test"))
                .andExpect(jsonPath("$.age").value("20"));

    }

    @Test
    void getAllLordNoPlanet() throws Exception {

        mockMvc.perform(get("http://localhost:8080/lord/allLord"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));
    }

    @Test
    void addPlanet() throws Exception {

        Lord lord = repositoryLord.getYoungLordLimit(1l).get(0);

        mockMvc.perform(patch("http://localhost:8080/lord/addPlanet")
                        .param("namePlanet", "Mars")
                        .param("lordId", String.valueOf(lord.getId())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(lord.getName()))
                .andExpect(jsonPath("$.planetDto.size()").value(1));
    }

    @Test
    void getYoungLordLimit() throws Exception {

        mockMvc.perform(get("http://localhost:8080/lord/limitLordYoung/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1));
    }


}