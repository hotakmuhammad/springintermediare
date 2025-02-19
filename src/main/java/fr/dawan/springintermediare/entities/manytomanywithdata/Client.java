package fr.dawan.springintermediare.entities.manytomanywithdata;

import java.util.HashSet;
import java.util.Set;

import fr.dawan.springintermediare.entities.heritage.BaseEntity;
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
@Table(name="clients")
public class Client extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    
    private String prenom;
    
    
    private String nom;
    
    private Set<ArticleClient> articles = new HashSet<>();
    
    
    
}