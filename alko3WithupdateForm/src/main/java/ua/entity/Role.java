package ua.entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String role;
	
	@OneToMany(mappedBy="role")
	private List<Uzer> uzer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

	
	public List<Uzer> getUzer() {
		return uzer;
	}

	public void setUzer(List<Uzer> uzer) {
		this.uzer = uzer;
	}

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

}

