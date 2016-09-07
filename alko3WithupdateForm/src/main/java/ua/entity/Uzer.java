package ua.entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(indexes={@Index(columnList="name"), @Index(columnList="login"), 
		@Index(columnList="mail")})
public class Uzer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String login;
	
	private String pass;
	@ManyToOne(fetch=FetchType.LAZY)
	private Sex sex;
	@ManyToOne(fetch=FetchType.LAZY)
	private Role role;
	
	private String mail;
	
	@OneToMany(mappedBy="uzer")
    private List<Korzina> korzina;

	public List<Korzina> getKorzina() {
		return korzina;
	}

	public void setKorzina(List<Korzina> korzina) {
		this.korzina = korzina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
