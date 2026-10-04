package com.slimene.projet.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private ProjetDto projetDto;
    private DepartementDto departmentDto;
}
