package com.slimene.departement;

import com.slimene.departement.entites.Departement;
import com.slimene.departement.repos.DepartementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DepartementMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartementMicroserviceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(DepartementRepository departementRepository) {
        return args -> {
            departementRepository.save(Departement.builder()
                    .nomDeaprt("Developpement Web")
                    .build());

        };
    }
}
