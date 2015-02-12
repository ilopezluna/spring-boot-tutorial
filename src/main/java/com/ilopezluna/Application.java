package com.ilopezluna;

import com.ilopezluna.entities.Team;
import com.ilopezluna.repositories.TeamRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class Application {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

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