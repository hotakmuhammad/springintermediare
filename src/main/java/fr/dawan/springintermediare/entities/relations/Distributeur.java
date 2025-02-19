package fr.dawan.springintermediare.entities.relations;
import java.util.HashSet;
import java.util.Set;

import fr.dawan.springintermediare.entities.heritage.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
@Table(name="distributeurs")
public class Distributeur extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @Column(nullable = false, length=60)
    private String nom;
    
    @ManyToMany(mappedBy = "distributeurs")
    @Exclude
    private Set<Produit> produit=new HashSet<>();
}

