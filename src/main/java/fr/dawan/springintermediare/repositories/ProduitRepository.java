package fr.dawan.springintermediare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.dawan.springintermediare.entities.relations.Produit;
import fr.dawan.springintermediare.enums.Emballage;

//@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByPrix(double prixRechercher);
    
    List<Produit> findByPrixLessThan(double prixMax);
    
    List<Produit> findByEmballageAndPrixGreaterThan(Emballage emb, double prixMin);
    
    List<Produit> findByPrixBetween(double prixMin, double prixMax);
    
    List<Produit> findByEmballageIn(Emballage... emballages);
    
    List<Produit> findByDescriptionStartingWith(String prefix);
    
    List<Produit> findByDescriptionLike(String modele);
    
    List<Produit> findByPrixLessThanOrderByDescriptionDescPrix(double prixMax);
    
    
}


















