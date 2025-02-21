package fr.dawan.springintermediare.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode.Exclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Builder
public class MarqueDto {

    @PositiveOrZero(message = "L'id doit être supérieru ou égal à 0")
    private long id;
    
    @NotNull
    @Size(max=80)
    private String nom;
    
    @PastOrPresent
    private LocalDate dateCreation;
    
    @PositiveOrZero
    private long idIdentVisu;
    
    @Size(min=6,max=6)
    private String couleur;
    
    @NotNull
    @Size(max=60)
    private String police;

    @Exclude
    private byte[] logo;
}
