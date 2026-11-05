package com.slimene.departement.controller;

import com.slimene.departement.config.Configuration;
import com.slimene.departement.dto.DepartementDto;
import com.slimene.departement.entites.Departement;
import com.slimene.departement.service.DepartementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departements")
public class DepartementController {
    private DepartementService departementService;
    @Value("${build.version}")
    private String buildVersion;
    @Autowired
    Configuration configuration;
    public DepartementController(DepartementService departementService){
        this.departementService=departementService;
    }
    /*
    @GetMapping("{id}")
    public ResponseEntity<DepartementDto> getTeacherById(@PathVariable("id")
                                                     Long id )
    {
        return new ResponseEntity<DepartementDto>(
                departementService.getDepartementById(id), HttpStatus.OK);
    }*/
    @GetMapping("{code}")
    public DepartementDto getByCode(@PathVariable String code) {
        return departementService.getDepartementByCode(code);
    }
    @GetMapping("/version")
    public ResponseEntity<String> version()
    {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }
    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName()+" "+configuration.getEmail() );
    }


    }
