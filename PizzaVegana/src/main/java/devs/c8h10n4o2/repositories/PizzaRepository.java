package devs.c8h10n4o2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import devs.c8h10n4o2.entities.Pizza;

@Component
@Repository
public interface PizzaRepository extends CrudRepository <Pizza, Integer>{

//	Pizza findByPizzaId(int pizzaId);
//	
//	Pizza findByPizzaName(String pizzaName);
}
