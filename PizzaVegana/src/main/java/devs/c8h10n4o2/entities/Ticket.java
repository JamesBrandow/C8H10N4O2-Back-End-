package devs.c8h10n4o2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	
	
	@Column(name="client_id")
	private int clientId;
	
	@Column(name="cost")
	private double cost;

}
