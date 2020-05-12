package devs.c8h10n4o2.entities;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;
	@Column(name="role_title")
	private String title;
	@OneToMany(mappedBy = "userRole")
	private Set<Client> clients = new HashSet<Client>();
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRole(int roleId, String title) {
		super();
		this.roleId = roleId;
		this.title = title;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "User_Role [roleId=" + roleId + ", title=" + title + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roleId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if(obj instanceof UserRole) {
			UserRole other = (UserRole) obj;
			boolean sameId = (this.roleId == other.getRoleId());
			boolean sameTitle = (this.title.equals(other.getTitle()));
			if(sameId && sameTitle) res = true;
		} else res = false;
		return res;
	}
}