package fr.dawan.springintermediare;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import fr.dawan.springintermediare.dtos.MarqueDto;
import fr.dawan.springintermediare.services.MarqueService;

@Component
@Order(2)
public class ServiceRunner implements CommandLineRunner {

    @Autowired
    private MarqueService service;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Service Runner");
        
        service.getAll(Pageable.unpaged()).forEach(m -> System.out.println(m));
        
        MarqueDto dtoE  = MarqueDto.builder().nom("Marque E")
                .dateCreation(LocalDate.of(1984, 9, 23))
                .couleur("FFFFFF").police("Console").build();
        System.out.println(dtoE);
        
        
        MarqueDto dtoE2 =service.create(dtoE);
        System.out.println(dtoE2);
        
        MarqueDto dtoE3 = service.getById(dtoE2.getId());
        System.out.println(dtoE3);
        
        dtoE2.setNom("Marque E update");
        dtoE2.setDateCreation(LocalDate.now());
        dtoE2.setCouleur("000000");
        
        MarqueDto dtoE4 = service.getById(dtoE2.getId());
        System.out.println(dtoE4);
        
        
        dtoE4.setNom("");
        dtoE4.setCouleur("FF");
        MarqueDto dtoE5;
        try {
            dtoE5 = service.update(dtoE4, dtoE4.getId());
            System.out.println(dtoE5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

     
        
        
        service.deleteByID(dtoE2.getId());
        
        service.getAll(Pageable.unpaged()).forEach(m -> System.out.println(m));
    }

}
