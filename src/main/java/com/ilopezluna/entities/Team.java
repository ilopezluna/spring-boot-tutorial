package com.ilopezluna.entities;

import javax.persistence.*;

/**
 * Created by ignasi on 12/2/15.
 */

@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Team() {}

    public Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
