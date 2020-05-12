package devs.c8h10n4o2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import devs.c8h10n4o2.entities.PizzaItems;
import devs.c8h10n4o2.repositories.PizzaItemRepository;

@Component
@Service
public class PizzaItemService implements PizzaItemServiceI{

	@Autowired
	PizzaItemRepository pir;
	
	@Override
	public PizzaItems getItemById(int id) {
		return pir.findByItemId(id);
	}

	@Override
	public PizzaItems getItemByName(String itemName) {
		return pir.findByItemName(itemName).get(0);
	}
 
	@Override
	public List<PizzaItems> getByCategory(String category) {
		List<PizzaItems> options = (List<PizzaItems>) pir.findByCategory(category);
		return options;
	}

	@Override
	public PizzaItems updatePizzaItems(PizzaItems pi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePizzaItems(PizzaItems pi) {
		// TODO Auto-generated method stub
		return false;
	}

}