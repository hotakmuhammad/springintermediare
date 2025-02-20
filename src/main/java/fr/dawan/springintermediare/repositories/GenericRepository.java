package fr.dawan.springintermediare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import fr.dawan.springintermediare.entities.heritage.BaseEntity;


@NoRepositoryBean
public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
    
    int removeById(Long id);

}
