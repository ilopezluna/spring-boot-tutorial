package com.ilopezluna;

import com.ilopezluna.entities.Team;
import com.ilopezluna.repositories.TeamRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        TeamRepository teamRepository = applicationContext.getBean(TeamRepository.class);

        Team team = new Team("Wallapopers");
        teamRepository.save(team);

        for (Team current : teamRepository.findAll()) {
            System.out.println("Current team: " + current.toString());
        }
    }
}