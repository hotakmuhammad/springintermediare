package fr.dawan.springintermediare.services;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.dawan.springintermediare.dtos.MarqueDto;
import jakarta.validation.Valid;



public interface MarqueService {

    Page<MarqueDto> getAll (Pageable page);
    
    MarqueDto getById(long id);
    
    List<MarqueDto> getByNom(String nom);
    
    void deleteByID(long id);
    
    MarqueDto create(@Valid MarqueDto dto);
    
    MarqueDto update(@Valid MarqueDto dto, long id);
    
}
