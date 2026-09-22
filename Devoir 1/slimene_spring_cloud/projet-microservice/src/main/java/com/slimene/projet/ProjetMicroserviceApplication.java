package com.slimene.projet;

import com.slimene.projet.entities.Projet;
import com.slimene.projet.repos.ProjetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ProjetMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetMicroserviceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProjetRepository departmentRepository) {
        return args -> {
            departmentRepository.save(Projet.builder()
                    .projName("Info Tech")
                            .depCode("DW")
                    .build());
            departmentRepository.save(Projet.builder()
                    .projName("Marketing")
                            .depCode("DW")
                    .build());
        };
    }
    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}
