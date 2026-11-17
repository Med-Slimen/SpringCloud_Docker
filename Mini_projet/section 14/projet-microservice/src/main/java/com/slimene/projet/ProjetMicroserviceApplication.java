package com.slimene.projet;

import com.slimene.projet.entities.Projet;
import com.slimene.projet.repos.ProjetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class ProjetMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetMicroserviceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProjetRepository departmentRepository) {
        return args -> {
            departmentRepository.save(Projet.builder()
                    .projName("Creation Site Web")
                            .depCode("DW")
                            .email("ahmed@gmail.com")
                            .mobileNumber("23464098")
                    .build());
            departmentRepository.save(Projet.builder()
                    .projName("Creation d affiche")
                            .depCode("DN")
                    .email("med@gmail.com")
                    .mobileNumber("34654789")
                    .build());
        };
    }
    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}
