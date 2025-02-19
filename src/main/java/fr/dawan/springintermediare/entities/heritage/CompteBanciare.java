package fr.dawan.springintermediare.entities.heritage;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//
@Entity
@Table(name="compte_bancaire")
@SequenceGenerator(name = "compte_sequence")

/*
 *      @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
        @DiscriminatorColumn(name = "comte_discriminator", discriminatorType = DiscriminatorType.STRING, length=2)
        @DiscriminatorValue("CB")
        
        
        @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
        @SequenceGenerator(name="compte_sequence")
 */

@Inheritance(strategy = InheritanceType.JOINED)
public class CompteBanciare implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compte_sequence" )
    private long id;
    
    @Column(nullable=false, length=60)
    private String titulaire;
    
    
    @Column(nullable=false)
    private double solde;
}
