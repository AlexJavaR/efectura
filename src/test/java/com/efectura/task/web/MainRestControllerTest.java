package com.efectura.task.web;

import com.efectura.task.dto.DocumentDTO;
import com.efectura.task.model.Document;
import com.efectura.task.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainRestControllerTest {

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
                .andExpect(status().isNoContent())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void createDocumentAndGetCreatedDocument() throws Exception {
        DocumentDTO documentDTO = new DocumentDTO(true, "TestName", Arrays.asList("7", "15", "23"));
        Document document = new Document(true, new User("TestSession", "TestName"), "2,9,17");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonDTO = ow.writeValueAsString(documentDTO);
        String json = ow.writeValueAsString(document);

        this.mockMvc.perform(post("/document")
                .contentType(MediaType.APPLICATION_JSON).content(jsonDTO))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonDTO));
    }
}