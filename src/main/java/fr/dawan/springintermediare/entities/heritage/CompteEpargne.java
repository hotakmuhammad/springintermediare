package fr.dawan.springintermediare.entities.heritage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
//@DiscriminatorValue("CE")
@Table(name="compte_epargne")
public class CompteEpargne extends CompteBanciare {

    
    private static final long serialVersionUID = 1L;
    
    
    @Column(nullable=false)
    private double taux;
}
