package fr.dawan.springintermediare.entities.relations;

import java.util.HashSet;
import java.util.Set;

import fr.dawan.springintermediare.entities.heritage.BaseEntity;
import fr.dawan.springintermediare.enums.Emballage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name="produits")
public class Produit extends BaseEntity{
    
    
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 200)
    private String description;
    
    @Column(nullable = false)
    private double prix;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length=15)
    private Emballage emballage;
    
    @ManyToOne
    @Exclude
    private Marque marque;

    
    @ManyToMany
    @Exclude
//  @JoinTable(
            //  name="produits2distributeurs",
            //  joinColumns = @JoinColumn(name="id_produits"),
            //  inverseJoinColumns =  @JoinColumn(name="id_distributeurs")
            //  )

    private Set<Distributeur> distributeurs=new HashSet<>();
    
    


}
