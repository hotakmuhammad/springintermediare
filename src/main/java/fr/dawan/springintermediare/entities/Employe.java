package fr.dawan.springintermediare.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import fr.dawan.springintermediare.enums.ContratTravail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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

@Entity
@Table(name="employes")
public class Employe implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    
    @Column(nullable=false, length=60)
    private String prenom;
    
    @Column(nullable=false, length=60) //nullable = false -> NOT NULL
    private String nom;
    
    @Transient
    private int nePasPersister;
    
    @Column(name="date_naissance", nullable=false)
    private LocalDate dateNaissance;
    
    
    @Column(unique=true, nullable=false)
    private String email;
    
    
    //Nombre à virgule fixe en SQL DECIMAL ou NUMERIC
    @Column(nullable=false, precision=6, scale=2) //xxx.xxx
    private BigDecimal salaire;
    
    
    @Column(name="nombre_heur_semaine", nullable=false)
    private double nombreHeuresSemaine;
    
    
    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private ContratTravail contrat;
    
    
    
    
    
    
    
}














