package fr.dawan.springintermediare.repositories;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import fr.dawan.springintermediare.entities.PrixEmballage;
import fr.dawan.springintermediare.entities.relations.Marque;
import fr.dawan.springintermediare.entities.relations.Produit;
import fr.dawan.springintermediare.enums.Emballage;
import jakarta.transaction.Transactional;

//@Repository
@Transactional
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByPrix(double prixRechercher);
    
    List<Produit> findByPrixLessThan(double prixMax);
    
    List<Produit> findByEmballageAndPrixGreaterThan(Emballage emb, double prixMin);
    
    List<Produit> findByPrixBetween(double prixMin, double prixMax);
    
    List<Produit> findByEmballageIn(Emballage... emballages);
    
    List<Produit> findByDescriptionStartingWith(String prefix);
    
    List<Produit> findByDescriptionLike(String modele);
    
    List<Produit> findByPrixLessThanOrderByDescriptionDescPrix(double prixMax);
    
    // expression de chemain -> équivant à une jointure interne
    
    List<Produit> findByMarque(Marque marque);
    List<Produit> findByMarqueNom(String nomMarque);
    
    List<Produit> findByMarqueDateCreationBefore(LocalDate dateBefore);
    
    List<Produit> findByMarqueIdentiteGraphPolice(String nomPoliceCharactere);
    
    List<Produit> findByDistributeursNom(String nom);
    
    List<Produit> findByDistributeursNomAndMarqueNom(String nomDistributeur, String nomMarque);
    
    //Exist
    
    boolean existsByEmballage(Emballage emb);
    
    //count
    int countByPrixLessThan(double prixMin);
    
    // Limiter le résultat
    List<Produit> findTopByPrixLessThan(double prixMin);
    
    Optional<Produit> findTopByOrderByPrixDesc(); // Le produit plus chèr
    
    List<Produit> findTop5ByOrderByPrix();
    
    List<Produit> findTop5ByEmballageOrderByPrix(Emballage emb);
    
    // Pagination
    
    Page<Produit> findByPrixLessThan(double prixMax, Pageable page);

    List<Produit> findByPrixGreaterThan(double prixMin,Pageable page);

    
    List<Produit> findByPrixGreaterThan(double prixMin, Sort trie);
    
    
    //JPQL
    
    @Query("SELECT p FROM Produit p WHERE p.prix = :prixProduit")
    List<Produit> findPrixJPQL(@Param("prixProduit") double prix);
    
    @Query("SELECT p FROM Produit p WHERE p.prix < :prixProduit")
    List<Produit> findByPrixInferieurAJPQL(double prixProduit);
    
    
    @Query("FROM Produit p WHERE p.prix < ?1AND emballage = ?2")
    List<Produit> findByPrixEtEmballageJPQL(double prixMax, Emballage emb);
    
    
    //Expression de chemin -> la relation doit être @ManyToOne ou @OneToOne
    @Query("FROM Produit p WHERE p.marque.nom = :nomMarque")
    List<Produit> getByNomMarque(String nomMarque);
    
    
    // erreur @ManyToMany @Query("FROM Produit p WHERE p.distributeurs.nom = : nomDistributeur")
    @Query("FROM Produit p JOIN p.distributeurs d WHERE d.nom = :nomDistributeur")
    List<Produit> getByNomDistributeur(String nomDistributeur);
    
    
    @Query("SELECT avg(p.prix) FROM Produit p GROUP BY p.emballage HAVING p.emballage = :emb")
    double moyenPrixEmballage(Emballage emb);
    
    
    @Query("SELECT new fr.dawan.springintermediare.entities.PrixEmballage(avg(p.prix),p.emballage) FROM Produit p GROUP BY p.emballage")
    List<PrixEmballage> moyenPrixEmballage();
    
    
    //SQL
    
    @Query(nativeQuery = true,  value = "SELECT * FROM produits WHERE prix = :prixProduit")
    List<Produit> findByPrixSQL(double prixProduit);
    
    //DELETE , UPDATE
    
    // nom de méthode
    // void deleteByMarqueNom(String nomMarque);
    int deleteByMarqueNom(String nomMarque);
    
    // JPQL
    @Modifying
    @Query("DELETE FROM Produit p WHERE p.marque.nom = :nomMarque")
    void effacerParNomMarque(String nomMarque);
    
    @Modifying
    @Query("UPDATE Produit p SET p.prix=p.prix*:pAugmentation WHERE prix>:prixMinimum")
    void augmentationPrix(double pAugmentation,double prixMinimum);

    //Procedure stockée
    @Procedure("GET_COUNT_BY_PRIX")
    int countByPrix(double prixMax);
    
    @Procedure
    int get_count_by_prix(double prixMax);
    
    
    
}


















