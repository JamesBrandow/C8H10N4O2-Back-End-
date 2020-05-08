package devs.c8h10n4o2.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pizza")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pizza_id")
	private int pizzaId;
	
	@ManyToOne
	@JoinColumn(name="ticket_id")
	private Ticket ticket;
	
	@Column(name="price")
	private double price;
	
	@Column(name="pizza_name")
	private String pizzaName;
	
	@Column(name = "pizza_status")
	private String status;

	@ManyToMany(mappedBy = "pizzas")
	Set<PizzaItems> items = new HashSet<PizzaItems>();

	public Pizza() {
		super();
		
	}

	public Pizza(int pizzaId, double price, String pizzaName) {
		this.pizzaId = pizzaId;
		this.price = price;
		this.pizzaName = pizzaName;
	}
	
	public Pizza(int pizzaId, Ticket ticket, double price, String pizzaName, String status) {
		super();
		this.pizzaId = pizzaId;
		this.ticket = ticket;
		this.price = price;
		this.pizzaName = pizzaName;
		this.status = status;
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<PizzaItems> getItems() {
		return items;
	}

	public void setItems(Set<PizzaItems> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Pizza [pizzaId=" + pizzaId + ", ticket=" + ticket + ", price=" + price + ", pizzaName=" + pizzaName
				+ "]";
	}
	
	

}