package com.ilopezluna.endpoints;

import com.ilopezluna.entities.Team;
import com.ilopezluna.services.TeamService;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

import static org.apache.commons.collections.IteratorUtils.*;

/**
 * Created by ignasi on 15/2/15.
 */
@RestController
public class TeamResource {

    @Autowired
    private TeamService teamService;

    @Autowired
    private CounterService counterService;

    @RequestMapping("/team")
    @ResponseBody
    public String get() {
        return teamService.findAll().toString();
    }
}
