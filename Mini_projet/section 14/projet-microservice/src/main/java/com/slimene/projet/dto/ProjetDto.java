package com.slimene.projet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetDto {
    private Long id;
    private String projName;
    private String depCode;
    private String nomDepart;
    private String email;
    private String mobileNumber;

}

