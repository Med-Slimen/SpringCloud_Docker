package com.slimene.projet.service;

import com.slimene.projet.dto.ProjetDto;

public interface ProjetService {
    ProjetDto getProjetByCode(String code);
}
