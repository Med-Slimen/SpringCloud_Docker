package com.slimene.projet.service;

import com.slimene.projet.dto.DepartementDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(url = "http://localhost:8080", value = "DEPARTEMENT")
public interface APIClient {
    @GetMapping("api/departements/{departement-code}")
    DepartementDto getDepByCode(@PathVariable("departement-code")
                               String departementCode
    );
}