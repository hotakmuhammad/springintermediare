package fr.dawan.springintermediare;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
/*
 * 
 
@Component
@Order(3)

*/
public class LogRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        
        log.trace("Message TRACE");
        log.debug("Message DEBUG");
        log.info("Message INFO");
        log.warn("Message WARN");
        log.error("Message ERROR");

    }

}
