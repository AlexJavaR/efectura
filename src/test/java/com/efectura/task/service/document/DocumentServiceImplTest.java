package com.efectura.task.service.document;

import com.efectura.task.dto.DocumentDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DocumentServiceImplTest {
    @MockBean
    private DocumentService documentService;

    @Test
    public void save() throws Exception {
        DocumentDTO documentDTO = new DocumentDTO(true, "nameTest", Arrays.asList("7", "15", "23"));

        Mockito.when(documentService.save(documentDTO, "sessionTest")).thenReturn(documentDTO);
    }

}