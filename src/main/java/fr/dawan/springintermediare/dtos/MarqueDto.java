package fr.dawan.springintermediare.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


@Builder
public class MarqueDto {

    private long id;
    
    private String nom;
    
    private LocalDate dateCreation;
    
    private long idIdentVisu;
    
    private String couleur;
    
    private String police;
    
    private byte[] logo;
}
