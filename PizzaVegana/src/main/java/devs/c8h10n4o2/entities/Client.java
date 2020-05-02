package devs.c8h10n4o2.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private int clientId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	
	
	@OneToOne
	@JoinColumn(name = "role_id")
	private UserRole userRole;
	
	
	
	public Client() {
		super();
	}

	public Client(int clientId, String username, String password, UserRole userRole) {
		super();
		this.clientId = clientId;
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", username=" + username + ", password=" + password + ", userRole="
				+ userRole + "]";
	}

	public boolean equals(Object obj) {
		boolean res = false;
		if(obj instanceof Client) {
			Client other = (Client) obj;
			boolean sameUN = (this.username.equals(other.getUsername()));
			boolean samePW = (this.password.equals(other.getPassword()));
			if(sameUN && samePW) res = true;
		} else res = false;
		return res;
		
	}
	
}