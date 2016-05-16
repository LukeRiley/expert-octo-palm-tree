package io.trade.model;

import javax.persistence.*;
import java.time.*;

@Entity
public class Bid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "amount", nullable = false)
	private double amount;
	
	@Column(name = "date", nullable = false)
	private Instant date;

	@OneToOne
	private Users users;
	
	@OneToOne
	private Auction auction;
	
	public Bid(double amount, Instant date, Users user, Auction auction) {
		super();
		this.amount = amount;
		this.date = date;
		this.users = user;
		this.auction = auction;
	}

	public Bid() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Users getUser() {
		return users;
	}

	public void setUser(Users user) {
		this.users = user;
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

}
