package com.slimene.departement.service;
import com.slimene.departement.dto.DepartementDto;
import com.slimene.departement.entites.Departement;
import com.slimene.departement.repos.DepartementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service

public class DepartementServiceImpl implements DepartementService {
    private DepartementRepository departementRepository;

    @Override
    public DepartementDto getDepartementById(Long id) {
        Departement departement = departementRepository.findById(id).get();
        return new DepartementDto(
                departement.getId(),
                departement.getNomDeaprt(),
                departement.getDepCode()
        );
    }
    @Override
    public DepartementDto getDepartementByCode(String code) {
        Departement departement = departementRepository.findByDepCode(code);
        if (departement == null) {
            throw new RuntimeException("Departement not found with code: " + code);
        }
        return new DepartementDto(departement.getId(), departement.getDepCode(), departement.getNomDeaprt());
    }
}
