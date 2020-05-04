package devs.c8h10n4o2.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private int ticketId;
	
	@Column(name="placement_time")
	private String placementTime;
	
	@Column(name="status")
	private String status;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@Column(name="cost")
	private double cost;
	
	@OneToMany(mappedBy = "ticket")
	private Set<Pizza> pizzas = new HashSet<Pizza>();

	public Ticket() {
		super();
		
	}

	
	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getPlacementTime() {
		return placementTime;
	}

	public void setPlacementTime(String placementTime) {
		this.placementTime = placementTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	

}
