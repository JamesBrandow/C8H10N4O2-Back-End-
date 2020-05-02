package devs.c8h10n4o2.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("devs.c8h10n4o2.entities")
@ComponentScan("devs.c8h10n4o2")
@EnableJpaRepositories("devs.c8h10n4o2.repositories")
public class PizzaVeganaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaVeganaApplication.class, args);
	}

}
