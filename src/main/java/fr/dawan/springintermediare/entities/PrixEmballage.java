package fr.dawan.springintermediare.entities;

import fr.dawan.springintermediare.enums.Emballage;
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
 
public class PrixEmballage {
 
    private double moyennePrix;
    
    private Emballage emballage;
    
}
