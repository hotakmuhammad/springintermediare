package fr.dawan.springintermediare.entities.manytomanywithdata;

import java.util.HashSet;
import java.util.Set;

import fr.dawan.springintermediare.entities.heritage.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@Table(name="articles")
public class Article extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    private String nom;
    
    
    @OneToMany(mappedBy = "article")
    private Set<ArticleClient> clients = new HashSet<>();
    
    
    
}
