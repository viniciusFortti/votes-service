package br.com.sicred.votesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VotesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VotesServiceApplication.class, args);
    }

}
