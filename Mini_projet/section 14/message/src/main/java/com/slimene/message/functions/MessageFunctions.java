package com.slimene.message.functions;

import com.slimene.message.dto.ProjetMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;
@Configuration
public class MessageFunctions {
    private static final Logger log =
            LoggerFactory.getLogger(MessageFunctions.class);
    @Bean
    public Function<ProjetMessageDto,ProjetMessageDto> email() {
        return projetMsgDto -> {
            log.info("Sending email with the details : " +
                    projetMsgDto.toString());
            return projetMsgDto;
        };
    }
    @Bean
    public Function<ProjetMessageDto,Long> sms() {
        return projetMsgDto -> {
            log.info("Sending sms with the details : " +
                    projetMsgDto.toString());
            return projetMsgDto.projetId();
        };
    }

}
