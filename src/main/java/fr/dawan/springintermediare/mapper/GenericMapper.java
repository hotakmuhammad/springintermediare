package fr.dawan.springintermediare.mapper;

public interface GenericMapper<T, TDto> {

    
    TDto toDto(T entite);
    
    T toEntity(TDto dto);
    
    void  update(TDto dto, T entite);
}
