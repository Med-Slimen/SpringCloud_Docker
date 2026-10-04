package com.slimene.projet.service;

import com.slimene.projet.dto.APIResponseDto;
import com.slimene.projet.dto.ProjetDto;

public interface ProjetService {
    APIResponseDto getProjetById(Long id);
}
