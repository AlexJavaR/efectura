package com.efectura.task.web;

import com.efectura.task.dto.DocumentDTO;
import com.efectura.task.model.Document;
import com.efectura.task.model.Sector;
import com.efectura.task.model.User;
import com.efectura.task.service.document.DocumentService;
import com.efectura.task.service.sector.SectorService;
import com.efectura.task.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
//@RequestMapping(produces = "APPLICATION_JSON")
public class MainRestController {

    private final UserService userService;
    private final SectorService sectorService;
    private final DocumentService documentService;

    @Autowired
    public MainRestController(UserService userService, SectorService sectorService, DocumentService documentService) {
        this.userService = userService;
        this.sectorService = sectorService;
        this.documentService = documentService;
    }

    @GetMapping("/home")
    public String home(HttpServletResponse response, HttpServletRequest request) {
        return "/home";
    }

    @GetMapping("/user")
    public User getUserBySession(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        return userService.getBySession(sessionId);
    }

    @GetMapping("/sectors")
    public ResponseEntity<List<Sector>> getAllSectors() {
        return new ResponseEntity<>(sectorService.findAllByParentId(null), HttpStatus.OK);
    }

    @GetMapping(value = "/document")
    public ResponseEntity<DocumentDTO> getExistDocument(HttpServletResponse response, HttpServletRequest request) {
        String jsessionid = request.getParameter("JSESSIONID");
        String sessionId = request.getSession().getId();
        response.setContentType("application/json;charset=UTF-8");
        DocumentDTO documentDTO = documentService.getBySession(sessionId);
        if (documentDTO != null)
            return new ResponseEntity<>(documentDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/document")
    public ResponseEntity<DocumentDTO> createDocument(HttpServletRequest request,
                                                 @RequestBody DocumentDTO documentDTO) {
        String sessionId = request.getSession().getId();
        DocumentDTO document = documentService.save(documentDTO, sessionId);

        return new ResponseEntity<>(document, HttpStatus.CREATED);
    }
}
