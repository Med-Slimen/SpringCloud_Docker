package com.slimene.projet.repos;

import com.slimene.projet.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet,Long> {
    Projet findByProjCode(String code);
}
