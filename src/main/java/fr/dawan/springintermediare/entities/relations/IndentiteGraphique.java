package fr.dawan.springintermediare.entities.relations;



import fr.dawan.springintermediare.entities.heritage.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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


@Entity
@Table(name="identite_graphiques")
public class IndentiteGraphique extends BaseEntity{

    
    private static final long serialVersionUID = 1L;
    
    @Column(length=6)
    private String couleur;
    
    @Column(length=60)
    private String police;
    
    @Exclude
    @Lob
    private byte[] logo;
    
    
    @OneToOne(mappedBy = "identiteGraph")
    @Exclude
    private Marque marque;

    
}
