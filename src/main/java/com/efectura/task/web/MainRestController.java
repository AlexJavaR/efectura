package com.efectura.task.web;

import com.efectura.task.model.Sector;
import com.efectura.task.model.User;
import com.efectura.task.service.sector.SectorService;
import com.efectura.task.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainRestController {

    private final UserService userService;
    private final SectorService sectorService;

    @Autowired
    public MainRestController(UserService userService, SectorService sectorService) {
        this.userService = userService;
        this.sectorService = sectorService;
    }

    @GetMapping("/home")
    public String home(HttpServletResponse response, HttpServletRequest request) {
        return "/home";
    }

    @GetMapping("/user")
    public User getUserBySession(HttpServletResponse response, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        return userService.getBySession(sessionId);
    }

    @GetMapping("/sectors")
    public ResponseEntity<List<Sector>> getAllSectors(HttpServletResponse response, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        User user = userService.getBySession(sessionId);

        return new ResponseEntity<>(sectorService.findAllByParentId(null), HttpStatus.OK);
    }
}
