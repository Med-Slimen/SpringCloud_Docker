package com.slimene.projet.restControllers;

import com.slimene.projet.config.Configuration;
import com.slimene.projet.dto.APIResponseDto;
import com.slimene.projet.dto.ProjetDto;
import com.slimene.projet.entities.Projet;
import com.slimene.projet.service.ProjetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projets")
@AllArgsConstructor
public class ProjetController {
    private ProjetService projetService;
    @Autowired
    Configuration configuration;
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getProjetById(@PathVariable("id")
                                                      Long id )
    {
        return new ResponseEntity<APIResponseDto>(
                projetService.getProjetById(id),
                HttpStatus.OK);
    }
    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName()+" "+configuration.getEmail() );
    }
    @PostMapping("/create")
    public ResponseEntity<String> createTeacher(@RequestBody ProjetDto
                                                        projetDto) {
        projetService.createProjet(projetDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Projet created successfully");
    }

}

