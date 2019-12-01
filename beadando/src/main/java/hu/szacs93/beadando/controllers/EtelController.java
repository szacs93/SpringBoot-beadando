package hu.szacs93.beadando.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.szacs93.beadando.Etel;

@RestController
@RequestMapping("/etel")
public class EtelController {
	
	@Autowired
	private JpaEtelRepo repository;

	@RequestMapping(value = "/uj", method = RequestMethod.POST)
	  public String ujEtel(@RequestParam(value="name", defaultValue="") String name, @RequestParam(value="price", defaultValue="0") int price, @RequestParam(value="kaloria", defaultValue="0") int kaloria, @RequestParam(value="gluten", defaultValue="False") boolean gluten, @RequestParam(value="tej", defaultValue="False") boolean tej) {
		if(name != "" && price != 0) {
			System.out.println(gluten + " " + tej);
			Etel ujetel = new Etel(name, price, kaloria, gluten, tej);
			System.out.println(ujetel.getDetails());
			repository.save(ujetel);
			return "Sikeres adatbevitel.<br>(" + ujetel.ToString() + ")";
			}
		else
			return "Hiányos adatok. (Név és ár kitöltése kötelező.)<br><a href='/editor'>Vissza a felvételhez</a>";
	  }
	
	@RequestMapping("/adatok")
	  public String etelAdatok(@RequestParam(value="id", defaultValue="0") int id) {
	    Etel akt = repository.findById(id);
	    String tmp = "<p>Név: " + akt.getName() + "</p>" +
	    		"<p>Ár: " + akt.getPrice() + "Ft</p>" +
	    		"<p>Kalória: " + akt.getKaloria() + "kcal</p>" +
	    		((akt.isGluten()) ? "<p><b>Glutént tartalmaz</b></p>" : "") +
	    		((akt.isTej()) ? "<p><b>Tejet tartalmaz</b></p>" : "");
	    return tmp;
	  }
	
	@RequestMapping("/torles")
	  public String etelTorles(@RequestParam(value="id", defaultValue="0") int id) {
		Etel torlendo = repository.findById(id);
		String tmp = "Törölve: " + torlendo.getDetails();
		repository.delete(torlendo);
		return tmp;
	}
	
	@RequestMapping("/etlap")
	  public String etlap() {
		String[] tmp= {""};
		repository.findAll().forEach(x -> tmp[0]+=x.getDetails()+"\n");
		return tmp[0];
	  }
}
