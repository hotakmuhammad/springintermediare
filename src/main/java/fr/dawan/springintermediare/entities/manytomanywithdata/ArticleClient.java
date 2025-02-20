package fr.dawan.springintermediare.entities.manytomanywithdata;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
public class ArticleClient implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private ArticleClientPk id = new ArticleClientPk();
    
    @ManyToOne
    @MapsId("articleId")
    private Article article;
    
    
    @ManyToOne
    @MapsId("clientId")
    private Client client;
    
    private int quantite;
    
    
}













