package fr.dawan.springintermediare.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.dawan.springintermediare.enums.ContratTravail;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
//import jakarta.persistence.TableGenerator;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;
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
/*
 * 

@TableGenerator(name="emp_generator", table="tab_gen", pkColumnName = "seq", valueColumnName = "next_id", initialValue = 1,
    allocationSize = 1)
    
*/
@SequenceGenerator(name = "seq_generator", sequenceName = "sequence1", allocationSize = 1, initialValue = 1)
public class Employe implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 2-> BDD auto_incremetn
    //@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_generator") //3-> ORM
    private Long id;
    
    @Version
    private int version;
    
    
    
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
    
    @Lob
    @Column// par défaut avec mariadb / mysql
    private byte[] photo;
    
    
    @Embedded
    private Adresse adressePerso;
 
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="rue", column=@Column(name="rue_pro")),
        @AttributeOverride(name = "ville", column=@Column(name="ville_pro")),
        @AttributeOverride(name="codePostal", column=@Column(name="code_postal_pro", length=20))
    })
    private Adresse adressePro;
   
    // Mapping des collections simples
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "commentaires", joinColumns = @JoinColumn(name = "id_employes"))
    @Column(name = "commentaire", length = 150)
    private List<String> commentaires = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "telephones", joinColumns = @JoinColumn(name = "id_employes"))
    @MapKeyColumn(name = "type_telephone", length = 30)
    @Column(name = "numero_telephone", length = 20)
    private Map<String, String> telephones = new HashMap<>();

    
}














