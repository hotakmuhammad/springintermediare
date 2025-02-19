package fr.dawan.springintermediare.entities.manytomanywithdata;

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
public class ArticleClientPk {

    
    private long articleId;
    
    
    private long clientId;
    
    
    
    
    
}



