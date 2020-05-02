package devs.c8h10n4o2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pizza")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pizzaId;
	
	
	
	
	@Column(name="ticket_id")
	private int ticketId;
	
	@Column(name="price")
	private double price;
	
	@Column(name="pizza_name")
	private String pizzaName;

}
