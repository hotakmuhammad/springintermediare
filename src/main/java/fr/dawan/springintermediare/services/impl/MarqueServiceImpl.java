package fr.dawan.springintermediare.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import fr.dawan.springintermediare.dtos.MarqueDto;
import fr.dawan.springintermediare.entities.relations.Marque;
import fr.dawan.springintermediare.exception.IdNotFoundException;
import fr.dawan.springintermediare.mapper.MarqueMapper;
import fr.dawan.springintermediare.repositories.MarqueRepository;
import fr.dawan.springintermediare.services.MarqueService;



@Service
@Transactional
@Validated
public class MarqueServiceImpl implements MarqueService {
    
    
    //@Autowired
    private MarqueRepository repository;
    
    // 1 Constructeur @Autowired implicite
    private MarqueMapper mapper;

    // 1 constructeur = @Autowired implicite
    public MarqueServiceImpl(MarqueRepository repository, MarqueMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<MarqueDto> getAll(Pageable page) {
        
        Page<Marque> marques = repository.findAll(page);
        
        
        return marques.map(m -> mapper.toDto(m));
    }

    
    @Transactional(readOnly = true)
    @Override
    public MarqueDto getById(long id) {
        Marque marque =  repository.findById(id).orElseThrow(() -> new IdNotFoundException());
        return mapper.toDto(marque);
    }

    @Override
    public List<MarqueDto> getByNom(String nom) {
        List<Marque> marques = repository.findByNomLike(nom+"%");
        return null;
    }

    @Override
    public void deleteByID(long id) {
        if(repository.removeById(id)==0){
            throw new IdNotFoundException();
        }

    }



    @Override
    public MarqueDto create(MarqueDto dto) {
        
        return mapper.toDto(repository.save(mapper.toEntity(dto))) ;
    }

    @Override
    public MarqueDto update(MarqueDto dto, long id) {
        Marque marque = repository.findById(id).orElseThrow(()-> new IdNotFoundException());
        mapper.update(dto, marque);
        return mapper.toDto(repository.save(marque));
        
      
    }

}
