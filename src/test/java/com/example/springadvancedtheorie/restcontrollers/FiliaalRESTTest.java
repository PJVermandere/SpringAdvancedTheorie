package com.example.springadvancedtheorie.restcontrollers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/rest.sql")
class FiliaalRESTTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final MockMvc mock;

    FiliaalRESTTest(MockMvc mock) {
        this.mock = mock;
    }

    long idVanTest(){
        return jdbcTemplate.queryForObject("select id from rest.filialen where naam = ?", Long.class, "test");
    }

    @Test
    public void onbestaandeId() throws Exception{
        mock.perform(get("/filialen/{id}", -1))
                .andExpect(status().isNotFound());
    }
    @Test
    void bestaandeId() throws Exception{
        var id = idVanTest();
        mock.perform(get("/filialen/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(id));
    }
}