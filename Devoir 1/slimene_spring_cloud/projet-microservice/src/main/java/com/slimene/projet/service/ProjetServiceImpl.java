package com.slimene.projet.service;

import com.slimene.projet.dto.ProjetDto;
import com.slimene.projet.entities.Projet;
import com.slimene.projet.repos.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetServiceImpl implements ProjetService {
    @Autowired
    ProjetRepository projetRepository;
    @Override
    public ProjetDto getProjetByCode(String code) {
        Projet prod = projetRepository.findByProjCode(code);
        ProjetDto projetDto = new ProjetDto(
                prod.getId(),
                prod.getProjName(),
                prod.getProjCode()
        );
        return projetDto;
    }
}