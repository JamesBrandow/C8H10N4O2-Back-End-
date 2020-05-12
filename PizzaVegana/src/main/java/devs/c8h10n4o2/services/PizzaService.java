package devs.c8h10n4o2.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import devs.c8h10n4o2.entities.Pizza;
import devs.c8h10n4o2.repositories.PizzaRepository;

@Component
@Service
public class PizzaService implements PizzaServiceI {

	@Autowired
	PizzaRepository pr;
	
	@Override
	public Pizza createPizza(Pizza p) {
		p = pr.save(p);
		return p;
	}
	
	@Override
	public Pizza getPizzaById(int id) {
		return pr.findById(id).get();
	}
	
	@Override
	public List<Pizza> getAllPizza() {
		List<Pizza> pizzas = (List<Pizza>) pr.findAll();
		return pizzas;
	}
	
	@Override
	public Pizza updatePizza(Pizza p) {
		return pr.save(p);
	}
	
	@Override
	public boolean deletePizza(Pizza p) {
		try {
			pr.delete(p);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
