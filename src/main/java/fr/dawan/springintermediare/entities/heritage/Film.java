package fr.dawan.springintermediare.entities.heritage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@ToString(callSuper = true)

@Entity
@Table(name = "films")
public class Film extends BaseEntity{
    
    private static final long serialVersionUID = 1L;
    
    
    
    @Column(length = 150, nullable = false)
    private String titre;
    
    @Column(nullable = false)
    private int duree;
    
    @Column(name = "annee_sortie", nullable = false)
    private int anneeSortie;

}
