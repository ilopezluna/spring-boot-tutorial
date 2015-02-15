package com.ilopezluna.services;

import com.ilopezluna.entities.Team;
import com.ilopezluna.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ignasi on 15/2/15.
 */
@Service
@Transactional
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private CounterService counterService;

    @Autowired
    private GaugeService gaugeService;

    public Iterable<Team> findAll() {

        long init = System.currentTimeMillis();
        counterService.increment("com.ilopezluna.services.TeamService.findAll().counter");

        Iterable<Team> all = teamRepository.findAll();
        long elapsed = System.currentTimeMillis() - init;

        gaugeService.submit("com.ilopezluna.services.TeamService.findAll().gauge", elapsed);

        return all;
    }
}
