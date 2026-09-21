package com.slimene.projet.restControllers;

import com.slimene.projet.dto.ProjetDto;
import com.slimene.projet.service.ProjetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projets")
@AllArgsConstructor
public class ProjetController {
    private ProjetService projetService;
    @GetMapping("{code}")
    public ResponseEntity<ProjetDto> getProdByCode(@PathVariable("code")
                                                      String code )
    {
        return new ResponseEntity<ProjetDto>(
                projetService.getProjetByCode(code),
                HttpStatus.OK);
    }
}

