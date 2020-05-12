package devs.c8h10n4o2.services;

import java.util.List;

import devs.c8h10n4o2.entities.PizzaItems;

public interface PizzaItemServiceI {

	PizzaItems getItemById(int id);
	PizzaItems getItemByName(String itemName);
	List<PizzaItems> getByCategory(String category);
	PizzaItems updatePizzaItems(PizzaItems pi);
	boolean deletePizzaItems(PizzaItems pi);
}


//PizzaItems createPizzaItem(PizzaItems pi);
//PizzaItems getPizzaItemsById(int id);
//List<PizzaItems> getAllPizzaItems();
//PizzaItems updatePizzaItems(PizzaItems pi);
//boolean deletePizzaItems(PizzaItems pi);