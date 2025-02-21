package fr.dawan.springintermediare.entities.relations;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fr.dawan.springintermediare.entities.auditing.BaseAuditing;
import fr.dawan.springintermediare.entities.heritage.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)

@Entity
@Table(name="marques")

public class Marque extends BaseAuditing{
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 80)
    private String nom;
    
    @Column(name="date_creation")
    private LocalDate dateCreation;
    
    @OneToOne(cascade = CascadeType.ALL)
    @Exclude
    private IndentiteGraphique identiteGraph;

    @OneToMany(mappedBy = "marque")
    @Exclude
    private Set<Produit> produits=new HashSet<>();
            
        /*
         * 	  relation unidirectionnelle avec un @OneToMany
    		  @OneToMany
    		  @JoinColumn(name="produits_id")
    		  private Set<Produit> produits=new HashSet<>();
         */
    

}
