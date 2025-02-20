package fr.dawan.springintermediare.repositories.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import fr.dawan.springintermediare.entities.relations.Marque;
import fr.dawan.springintermediare.repositories.MarqueCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;


@Repository
public class MarqueCustomRepositoryImpl implements MarqueCustomRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Marque> findByNomAndDateCreation(String nom, LocalDate dateCreation) {
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Marque> query = cb.createQuery(Marque.class);
        Root<Marque> marque = query.from(Marque.class);
        List<Predicate> predicates = new ArrayList<>();
        if(nom!=null) {
            predicates.add(cb.equal(marque.get("nom"), nom));
        }
        if(dateCreation != null) {
            predicates.add(cb.equal(marque.get("dateCreation"), dateCreation));
        }
        
        query.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(query).getResultList();

    }

}
