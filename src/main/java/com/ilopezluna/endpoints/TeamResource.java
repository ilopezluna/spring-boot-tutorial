package com.ilopezluna.endpoints;

import com.ilopezluna.entities.Team;
import com.ilopezluna.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
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

    @Autowired
    private CounterService counterService;

    @RequestMapping("/")
    @ResponseBody
    Iterable<Team> get() {
        counterService.increment("com.ilopezluna.endpoints.team.resource.find.all.counter");
        return teamService.findAll();
    }
}
