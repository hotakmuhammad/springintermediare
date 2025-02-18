package fr.dawan.springintermediare;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class RepositoryRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Repository Runner");

    }

}
