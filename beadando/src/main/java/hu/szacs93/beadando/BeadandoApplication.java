package hu.szacs93.beadando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.szacs93.beadando.controllers.JpaEtelRepo;

@SpringBootApplication
@RestController
@EnableJpaRepositories("hu.szacs93.beadando") 
@EntityScan("hu.szacs93.beadando")
public class BeadandoApplication {

	@Autowired
	private JpaEtelRepo repository;
	
	public static void main(String[] args) {
		SpringApplication.run(BeadandoApplication.class, args);
	}

	@RequestMapping(value = "/helloworld")
	   public String hello() {
		repository.save(new Etel("teszt2", 700, 600, false, false));
		System.out.println("\nfindAll()");
		repository.findAll().forEach(x -> System.out.println(x.toString()));
		return "index";
	   }
}
