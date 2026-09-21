package com.slimene.projet;

import com.slimene.projet.entities.Projet;
import com.slimene.projet.repos.ProjetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
                    .projCode("IT")
                    .build());
            departmentRepository.save(Projet.builder()
                    .projName("Marketing")
                    .projCode("MK")
                    .build());
        };
    }
}
