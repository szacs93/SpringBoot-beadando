package hu.szacs93.beadando;

import javax.persistence.*;

@Entity
@Table(name = "ETEL")
public class Etel {
	
	//CREATE TABLE ETEL (ID INT PRIMARY KEY, NEV VARCHAR(25), KALORIA INT, GLUTEN BOOLEAN, TEJ BOOLEAN);
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;
 
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private int price;
 
    @Column(nullable = false)
    private int kaloria;
    
    @Column(nullable = false)
    private boolean gluten;
    
    @Column(nullable = false)
    private boolean tej;
    
    public Etel()
    {
    }
    
    public Etel(String name, int price, int kaloria, boolean gluten, boolean tej) {
        this.name = name;
        this.price = price;
        this.kaloria = kaloria;
        this.gluten = gluten;
        this.tej = tej;
    }
    
    public String toString() {
    	return id + ": " + name + " " + price + "Ft " + kaloria + "kcal " + ((gluten == true) ? "(glutént tartalmaz)" : "") + " " + ((tej == true) ? "(tejet tartalmaz)" : "");
    }
    
    public String getDetails()
    {
    	return id + ";" + name + ";" + price + "Ft;" + kaloria + "kcal;" + gluten + ";" + tej;
    }
}
