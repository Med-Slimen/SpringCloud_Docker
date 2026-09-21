package com.slimene.projet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetDto {
    private Long id;
    private String ProjName;
    private String ProjCode;
    private String depCode;
}

