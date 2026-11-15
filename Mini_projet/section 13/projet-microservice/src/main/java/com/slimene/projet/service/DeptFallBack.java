package com.slimene.projet.service;

import com.slimene.projet.dto.DepartementDto;
import org.springframework.stereotype.Component;

@Component
public class DeptFallBack implements APIClient {
    @Override
    public DepartementDto getDepByCode(String departementCode) {
        return null;
    }
}