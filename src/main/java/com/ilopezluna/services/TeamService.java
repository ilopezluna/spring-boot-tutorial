package com.ilopezluna.services;

import com.ilopezluna.entities.Team;
import com.ilopezluna.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Iterable<Team> findAll() {
        Iterable<Team> all = teamRepository.findAll();
        return all;
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }
}
