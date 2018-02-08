package com.efectura.task.web;

import com.efectura.task.service.sector.SectorService;
import com.efectura.task.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainRestControllerTest {

    @Autowired
    private SectorService sectorService;

    @Autowired
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getAllSectors() throws Exception {
        this.mockMvc.perform(get("/sectors")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getExistDocument() throws Exception {
        this.mockMvc.perform(get("/document")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isNoContent());
//                .andExpect(content().contentTypeCompatibleWith("application/json;charset=UTF-8"));
    }

    @Test
    public void createDocument() throws Exception {
        this.mockMvc.perform(post("/document")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isNoContent());
//                .andExpect(content().contentTypeCompatibleWith("application/json;charset=UTF-8"));
    }
}