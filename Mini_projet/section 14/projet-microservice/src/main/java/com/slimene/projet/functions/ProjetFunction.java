package com.slimene.projet.functions;
import com.slimene.projet.service.ProjetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import java.util.function.Consumer;

public class ProjetFunction {
    private static final Logger log = LoggerFactory.getLogger(ProjetFunction.class);
    @Bean
    public Consumer<Long> updateCommunication(ProjetService projetService) {
        return projetId -> {
            log.info("Updating Communication status for the teacher Id : " + projetId.toString());
            projetService.updateCommunicationStatus(projetId);

        };
    }

}
