package fr.dawan.springintermediare.repositories;

import java.time.LocalDate;
import java.util.List;

import fr.dawan.springintermediare.entities.relations.Marque;

public interface MarqueCustomRepository {

    
    List<Marque> findByNomAndDateCreation(String nom, LocalDate dateCreation);
}
