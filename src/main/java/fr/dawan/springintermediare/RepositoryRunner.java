package fr.dawan.springintermediare;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import fr.dawan.springintermediare.entities.relations.Produit;
import fr.dawan.springintermediare.enums.Emballage;
import fr.dawan.springintermediare.repositories.ProduitRepository;


@Component
@Order(1)

public class RepositoryRunner implements CommandLineRunner {
    
    
    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Repository Runner");

        System.out.println(produitRepository.count()); 
        Produit prod=produitRepository.findById(2L) .get();
        System.out.println(prod);
        
        List<Produit> produits = produitRepository.findAll();
        
        for(var p : produits) {
            System.out.println(p);
        }
        
        
        produits = produitRepository.findByPrix(40.0);
        produits.forEach(p -> System.out.println(p));
        
        produitRepository.findByPrixLessThan( 100.0).forEach(p -> System.out.println(p));
        
        produitRepository.findByEmballageAndPrixGreaterThan(Emballage.CARTON, 40.0).forEach(p -> System.out.println(p));
        
        produitRepository.findByPrixBetween(10, 100).forEach(p -> System.out.println(p));
        
        produitRepository.findByEmballageIn(Emballage.SANS, Emballage.PLASTIQUE).forEach(p -> System.out.println(p));
        
        produitRepository.findByDescriptionStartingWith("Câb").forEach(p -> System.out.println(p));
        
        produitRepository.findByDescriptionLike("M__%").forEach(p -> System.out.println(p));
        produitRepository.findByDescriptionLike("%m%").forEach(p -> System.out.println(p));
        
        produitRepository.findByPrixLessThanOrderByDescriptionDescPrix(200.0).forEach(p -> System.out.println(p));
        
        
        
    }

}
