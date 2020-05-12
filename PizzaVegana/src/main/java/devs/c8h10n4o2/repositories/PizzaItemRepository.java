package devs.c8h10n4o2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import devs.c8h10n4o2.entities.PizzaItems;

@Component
@Repository
public interface PizzaItemRepository extends CrudRepository<PizzaItems, Integer>{

	List<PizzaItems> findByItemName(String itemName);
	PizzaItems findByItemId(int itemId);
	List<PizzaItems> findByCategory(String category);
	
}