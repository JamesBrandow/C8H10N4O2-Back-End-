package devs.c8h10n4o2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import devs.c8h10n4o2.entities.Pizza;
import devs.c8h10n4o2.services.PizzaService;

@Component
@Controller
@CrossOrigin("*")
public class PizzaController {

	@Autowired
	PizzaService ps;
	
	@ResponseBody
	@RequestMapping(value = "/pizzas", method = RequestMethod.POST)
	public Pizza createPizza(@RequestBody Pizza p) {
		System.out.println(p);
		return ps.createPizza(p); 
	}
	
	@ResponseBody
	@RequestMapping(value = "/pizzas/{id}", method = RequestMethod.GET)
	public Pizza getPizzaById(@PathVariable int id) {
		
		return ps.getPizzaById(id);
	} 
	
	@ResponseBody
	@RequestMapping(value = "/pizzas", method = RequestMethod.GET)
	public List<Pizza> getAllPizzas(){
		List<Pizza> pizzas = ps.getAllPizza();
		//for each pizza get all pizza_items 
				for(Pizza pizza : pizzas) {
					pizza.getItems(); 
				}

		return pizzas;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updatepizza", method = RequestMethod.PUT)
	public Pizza updatePizza(@RequestBody Pizza p) {
		Pizza q = ps.getPizzaById(p.getPizzaId());
		q.setStatus(p.getStatus());
		return ps.updatePizza(q);
	}
	
	@ResponseBody
	@RequestMapping(value = "/pizzas", method = RequestMethod.DELETE)
	public boolean deletePizza(Pizza p) {
		boolean result = ps.deletePizza(p);
		if(result == false) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to delete Pizza");
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pizzas/unbaked", method = RequestMethod.GET)
	public List<Pizza> getAllPizzaByStatus(){
		List<Pizza> pizzas = ps.getPizzaByStatus("unbaked");
		for(Pizza pizza : pizzas) {
			pizza.getItems(); 
		}
		return pizzas;
	}
}