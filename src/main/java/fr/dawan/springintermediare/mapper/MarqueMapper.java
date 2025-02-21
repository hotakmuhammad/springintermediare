package fr.dawan.springintermediare.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;

import fr.dawan.springintermediare.dtos.MarqueDto;
import fr.dawan.springintermediare.entities.relations.Marque;

@Mapper(componentModel = ComponentModel.SPRING)
public interface MarqueMapper extends GenericMapper<Marque, MarqueDto>{

    
    @Mapping(source = "identiteGraph.id", target = "idIdentVisu")
    @Mapping(source = "identiteGraph.couleur", target = "couleur")
    @Mapping(source = "identiteGraph.police", target = "police")
    @Mapping(source = "identiteGraph.logo", target = "logo")
    @Override
    MarqueDto toDto(Marque entite);
    
    @Mapping(target = "identiteGraph.id", source = "idIdentVisu")
    @Mapping(target = "identiteGraph.couleur", source = "couleur")
    @Mapping(target = "identiteGraph.police", source = "police")
    @Mapping(target = "identiteGraph.logo", source = "logo")
    @Override
    Marque toEntity(MarqueDto dto);
    
    void update(MarqueDto dto, @MappingTarget Marque entite);
    
    
}
