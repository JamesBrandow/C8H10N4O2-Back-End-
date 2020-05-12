package devs.c8h10n4o2.services;

import java.util.List;
import devs.c8h10n4o2.entities.Pizza;

public interface PizzaServiceI {
	
	Pizza createPizza(Pizza p);
	
	Pizza getPizzaById(int id);
	List<Pizza> getAllPizza();
	
	Pizza updatePizza(Pizza p);
	
	boolean deletePizza(Pizza p);
}
