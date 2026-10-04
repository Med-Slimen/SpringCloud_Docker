package com.slimene.departement.repos;
import com.slimene.departement.entites.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DepartementRepository extends JpaRepository<Departement, Long>{
    Departement findByDepCode(String code);
}
