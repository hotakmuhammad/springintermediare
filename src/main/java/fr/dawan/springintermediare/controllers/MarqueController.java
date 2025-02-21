package fr.dawan.springintermediare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.springintermediare.dtos.MarqueDto;
import fr.dawan.springintermediare.services.MarqueService;


@RestController
@RequestMapping("api/v1/marques")
public class MarqueController {
    
    @Autowired
    private MarqueService service;
    
    
    
    //@RequestMapping(value="", method=RequestMethod.GET)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MarqueDto> getAll(){
        return service.getAll(Pageable.unpaged()).getContent();
    }

    
    @GetMapping(params= {"page","size"},produces=MediaType.APPLICATION_JSON_VALUE)
    public List<MarqueDto> getAll(Pageable page){
        return service.getAll(page).getContent();
    }

    @GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public MarqueDto getById(@PathVariable long id){
        return service.getById(id);
    }

}
