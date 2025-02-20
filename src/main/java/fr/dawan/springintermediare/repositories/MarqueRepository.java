package fr.dawan.springintermediare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.springintermediare.entities.relations.Marque;

public interface MarqueRepository extends JpaRepository<Marque, Long> {

}
