package io.trade.model;

import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "real_name", nullable = false)
	private String realName;
	
	@Column(name = "biography", nullable = false)
	private String biography;
	
	@OneToOne
	private Users users;

	public UserDetails(String realName, String biography, Users user) {
		super();
		this.realName = realName;
		this.biography = biography;
		this.users = user;
	}

	public UserDetails() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Users getUser() {
		return users;
	}

	public void setUser(Users user) {
		this.users = user;
	}

}
