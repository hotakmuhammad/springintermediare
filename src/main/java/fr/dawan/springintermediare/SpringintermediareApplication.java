package fr.dawan.springintermediare;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringintermediareApplication implements CommandLineRunner {

	public static void main(String[] args) {
	    
	    
		SpringApplication.run(SpringintermediareApplication.class, args);
	    /*
	     * 
	    
    	    SpringApplication app=new SpringApplication(SpringintermediareApplication.class);
              app.setBannerMode(Mode.OFF);
              app.setAddCommandLineProperties(false);
              app.run(args);

	     */
		
		
	}

	 @Override
	    public void run(String... args) throws Exception {
	        System.out.println("Application started with CommandLineRunner!");
	    }
}
