package devs.c8h10n4o2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import devs.c8h10n4o2.entities.PizzaItems;

@Component
@Repository
public interface PizzaPizzaItemsRepository extends CrudRepository<PizzaItems, Integer> {

}
