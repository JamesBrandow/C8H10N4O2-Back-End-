package devs.c8h10n4o2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="topping")
public class Topping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int toppingId;
	
	@Column(name="topping_name")
	private String toppingName;
	
	@Column(name="topping_cost")
	private double toppingCost;
}
