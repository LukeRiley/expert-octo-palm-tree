package io.trade.model;

import javax.persistence.*;

@Entity
public class UserRoles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	private Users users;
	
	@Column(name = "role", nullable = false)
	private String role;
	
	public UserRoles(Users user, String role) {
		super();
		this.users = user;
		this.role = role;
	}

	public UserRoles() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUser() {
		return users;
	}

	public void setUser(Users user) {
		this.users = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
