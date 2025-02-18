package fr.dawan.springintermediare.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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


@Embeddable
public class Adresse {
    

    
 
    private String rue;
    

    private String ville;
    
    @Column(name = "code_postal", length = 20)
    private String codePostal;

}
