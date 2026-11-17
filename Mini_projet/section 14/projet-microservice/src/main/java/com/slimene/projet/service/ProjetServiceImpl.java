package com.slimene.projet.service;

import com.slimene.projet.dto.APIResponseDto;
import com.slimene.projet.dto.DepartementDto;
import com.slimene.projet.dto.ProjetDto;
import com.slimene.projet.dto.ProjetMessageDto;
import com.slimene.projet.entities.Projet;
import com.slimene.projet.exceptions.ResourceNotFoundException;
import com.slimene.projet.repos.ProjetRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
@AllArgsConstructor
@Service
public class ProjetServiceImpl implements ProjetService {
    private static final Logger log = LoggerFactory.getLogger(ProjetServiceImpl.class);
    private final StreamBridge streamBridge;
    @Autowired
    ProjetRepository projetRepository;
    @Autowired
    private WebClient webClient;
    @Autowired
    private APIClient apiClient;
    @Override
    public APIResponseDto getProjetById(Long id) {
        Projet projet = projetRepository.findById(id).get();
        DepartementDto departementDto = apiClient.getDepByCode(projet.getDepCode());
        /*
        DepartementDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departements/" +
                        projet.getDepCode())
                .retrieve()
                .bodyToMono(DepartementDto.class)
                .block();*/
        String dname;
        if(departementDto==null) dname="NOT AVAILABLE";
        else dname=departementDto.getNomDeaprt();
        ProjetDto projetDto = new ProjetDto(
                projet.getId(),
                projet.getProjName(),
                projet.getDepCode(),
                dname,
                projet.getEmail(),
                projet.getMobileNumber()
        );
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setProjetDto(projetDto);
        apiResponseDto.setDepartmentDto(departementDto);
        return apiResponseDto;
    }
    @Override
    public void createProjet(ProjetDto projetDto) {
        Projet savedProjet = projetRepository.save(Projet.builder()
                .projName(projetDto.getProjName())
                .depCode(projetDto.getDepCode())
                .email(projetDto.getEmail())
                .mobileNumber(projetDto.getMobileNumber())
                .build());
        sendCommunication(savedProjet);
    }
    private void sendCommunication(Projet projet) {
        var projetMsgDto = new ProjetMessageDto(projet.getId(),projet.getProjName(), projet.getEmail(),projet.getMobileNumber());
        log.info("Sending Communication request for the details: {}", projetMsgDto);
        var result = streamBridge.send("sendCommunication-out-0", projetMsgDto);
        log.info("Is the Communication request successfully triggered ? : {}",
                result);
    }
    @Override
    public boolean updateCommunicationStatus(Long projetId) {
        boolean isUpdated = false;
        if(projetId !=null ){
            Projet projet = projetRepository.findById(projetId).orElseThrow(
                    () -> new ResourceNotFoundException("Projet", "ProjetId", projetId.toString())
            );
            projet.setCommunicationDone(true);
            projetRepository.save(projet);
            isUpdated = true;
        }
        return isUpdated;
    }


}