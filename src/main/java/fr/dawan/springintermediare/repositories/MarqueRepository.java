package fr.dawan.springintermediare.repositories;

import java.util.List;

import fr.dawan.springintermediare.entities.relations.Marque;

//public interface MarqueRepository extends JpaRepository<Marque, Long> {

public interface MarqueRepository extends GenericRepository<Marque> {
    List<Marque> findByNomLike(String model);

}
