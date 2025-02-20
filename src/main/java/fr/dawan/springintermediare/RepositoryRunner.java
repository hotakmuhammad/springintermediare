package fr.dawan.springintermediare;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import fr.dawan.springintermediare.entities.relations.Marque;
import fr.dawan.springintermediare.entities.relations.Produit;
import fr.dawan.springintermediare.enums.Emballage;
import fr.dawan.springintermediare.repositories.MarqueCustomRepository;
import fr.dawan.springintermediare.repositories.MarqueRepository;
import fr.dawan.springintermediare.repositories.ProduitRepository;


@Component
@Order(1)

public class RepositoryRunner implements CommandLineRunner {
    
    
    @Autowired
    private ProduitRepository produitRepository;
    
    @Autowired
    private MarqueRepository marqueRepository;
    
    @Autowired
    private MarqueCustomRepository mcr;


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
        /*
         * 
        * 
         */
        Marque m1 = marqueRepository.findById(1L).get();
        produitRepository.findByMarque(m1).forEach(p -> System.out.println(p));
        
        produitRepository.findByMarqueNom("Marque B").forEach(p -> System.out.println(p));
        
        produitRepository.findByMarqueDateCreationBefore(LocalDate.of(1980, 10, 4)).forEach(p -> System.out.println(p));
        
        produitRepository.findByMarqueIdentiteGraphPolice("arial").forEach(p -> System.out.println(p));
         
        produitRepository.findByDistributeursNom("Distributeur 1").forEach(p -> System.out.println(p));
        
        produitRepository.findByDistributeursNomAndMarqueNom("Distributeur 1", "Marque 1").forEach(p -> System.out.println(p));
        
        System.out.println(produitRepository.existsByEmballage(Emballage.CARTON));
        
        System.out.println(produitRepository.countByPrixLessThan(40.0));
        
        System.out.println(produitRepository.findTopByPrixLessThan(100.0));
        
        System.out.println(produitRepository.findTopByOrderByPrixDesc().get());
        
        produitRepository.findTop5ByOrderByPrix().forEach(p -> System.out.println(p));
        
        produitRepository.findTop5ByEmballageOrderByPrix(Emballage.CARTON).forEach(p -> System.out.println(p));
        
        Page<Produit> p1 = produitRepository.findByPrixLessThan(700.0, PageRequest.of(1, 3));
        System.out.println(p1.getNumber());//1
        System.out.println(p1.getSize()); //3
        System.out.println(p1.getNumberOfElements()); // 3
        System.out.println(p1.getTotalElements()); //10
        System.out.println(p1.getTotalPages()); //4
        p1.getContent().forEach(p -> System.out.println(p));
        
        
        Sort sort = Sort.by("description").and(Sort.by(Direction.DESC, "prix"));
        produitRepository.findByPrixLessThan(700.0, PageRequest.of(1, 5, sort)).getContent().forEach(p -> System.out.println(p));
        

        produitRepository.findByPrixGreaterThan(0.0, PageRequest.of(1, 3)).forEach(p -> System.out.println(p));
        
        produitRepository.findByPrixGreaterThan(0.0,sort).forEach(p -> System.out.println(p));
  
        produitRepository.findByPrixGreaterThan(0.0,Pageable.unpaged()).forEach(p -> System.out.println(p));
        
        produitRepository.findByPrixGreaterThan(0.0,Sort.unsorted()).forEach(p -> System.out.println(p));
        
        System.out.println(produitRepository.moyenPrixEmballage(Emballage.CARTON));
        
        produitRepository.moyenPrixEmballage().forEach(p -> System.out.println(p));
        
        produitRepository.findByPrixSQL(19.0).forEach(p -> System.out.println(p));
        
        // DELETE, UPDATE
        int nbProduit=produitRepository.deleteByMarqueNom("Marque C");
        System.out.println(nbProduit);
        
        produitRepository.augmentationPrix(1.025, 50.0);


        produitRepository.augmentationPrix(1.025, 50.0);

        System.out.println(produitRepository.countByPrix(100.0));

        System.out.println(produitRepository.get_count_by_prix(100.0));
    
        mcr.findByNomAndDateCreation("Marque B", null).forEach(p -> System.out.println(p));
        mcr.findByNomAndDateCreation(null, LocalDate.of(1954,10,23)).forEach(p -> System.out.println(p));
        mcr.findByNomAndDateCreation("Marque B", LocalDate.of(1954,10,23)).forEach(p -> System.out.println(p));


        //Auditing
        Marque md = new Marque("Marque D", LocalDate.of(2000, 4, 1), null, new HashSet<>());
        System.out.println(md);
        md = marqueRepository.save(md);
        System.out.println(md);
        
        Marque ma = marqueRepository.findById(1L).get();
        ma.setDateCreation(LocalDate.of(1993, 7, 15));
        ma = marqueRepository.save(ma);
        System.out.println(ma);
        
        
    }

}
































