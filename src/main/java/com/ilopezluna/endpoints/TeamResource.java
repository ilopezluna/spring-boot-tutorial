package com.ilopezluna.endpoints;

import com.ilopezluna.entities.Team;
import com.ilopezluna.repositories.TeamRepository;
import com.ilopezluna.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ignasi on 15/2/15.
 */
@RestController
public class TeamResource {

    @Autowired
    private TeamService teamService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World! " + teamService.findAll();
    }
}
