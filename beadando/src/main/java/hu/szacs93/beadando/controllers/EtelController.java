package hu.szacs93.beadando.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.szacs93.beadando.Etel;

@RestController
public class EtelController {
	
	@Autowired
	private JpaEtelRepo repository;

	@RequestMapping(value = "/rest/UjEtel", method = RequestMethod.POST)
	  public String ujEtel(@RequestParam(value="name", defaultValue="") String name, @RequestParam(value="price", defaultValue="0") int price, @RequestParam(value="kaloria", defaultValue="0") int kaloria, @RequestParam(value="gluten", defaultValue="False") boolean gluten, @RequestParam(value="tej", defaultValue="False") boolean tej) {
		if(name != "" && price != 0) {
			System.out.println(gluten + " " + tej);
			Etel ujetel = new Etel(name, price, kaloria, gluten, tej);
			System.out.println(ujetel.getDetails());
			repository.save(ujetel);
			return "Sikeres adatbevitel";
			}
		else
			return "Hiányos adatok.";
	  }
	
	@RequestMapping("/rest/EtelAdatok")
	  public String etelAdatok(@RequestParam(value="id", defaultValue="0") int id) {
	    return repository.findById(id).toString();
	  }
	
	@RequestMapping("/rest/Etlap")
	  public String etlap() {
		String[] tmp= {""};
		repository.findAll().forEach(x -> tmp[0]+=x.getDetails()+"\n");
		return tmp[0];
	  }
}
