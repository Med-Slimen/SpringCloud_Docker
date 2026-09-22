package com.slimene.departement.controller;

import com.slimene.departement.dto.DepartementDto;
import com.slimene.departement.service.DepartementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departements")
@AllArgsConstructor
public class DepartementController {
    private DepartementService departementService;
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

}
