package fr.dawan.springintermediare.services;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.dawan.springintermediare.dtos.MarqueDto;



public interface MarqueService {

    Page<MarqueDto> getAll (Pageable page);
    
    MarqueDto getById(long id);
    
    List<MarqueDto> getByNom(String nom);
    
    void deleteByID(long id);
    
    MarqueDto create(MarqueDto dto);
    
    MarqueDto update(MarqueDto dto, long id);
    
}
