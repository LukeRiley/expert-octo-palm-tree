package io.trade.model;

import javax.persistence.*;

@Entity
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username", nullable = false)
	private User user;
	
	@Column(name = "role", nullable = false)
	private String role;
	
	public UserRole(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}

	public UserRole() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
