package com.slimene.projet.service;

import com.slimene.projet.dto.APIResponseDto;
import com.slimene.projet.dto.DepartementDto;
import com.slimene.projet.dto.ProjetDto;
import com.slimene.projet.entities.Projet;
import com.slimene.projet.repos.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProjetServiceImpl implements ProjetService {
    @Autowired
    ProjetRepository projetRepository;
    @Autowired
    private WebClient webClient;
    @Override
    public APIResponseDto getProjetById(Long id) {
        Projet projet = projetRepository.findById(id).get();
        DepartementDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departements/" +
                        projet.getDepCode())
                .retrieve()
                .bodyToMono(DepartementDto.class)
                .block();
        ProjetDto projetDto = new ProjetDto(
                projet.getId(),
                projet.getProjName(),
                projet.getDepCode()
        );
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setProjetDto(projetDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}