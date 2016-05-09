package io.trade.model;

import java.time.Instant;

import javax.persistence.*;


public class Auction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "start_date", nullable = false)
	private Instant startDate;
	
	@Column(name = "end_date", nullable = false)
	private Instant endDate;
	
	@ManyToOne
	private Item item;
	
	@ManyToOne
	private Users user;
		
	public Auction(Instant startDate, Instant endDate, Item item, Users user) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.item = item;
		this.user = user;
	}

	public Auction() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getStartDate() {
		return startDate;
	}

	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}

	public Instant getEndDate() {
		return endDate;
	}

	public void setEndDate(Instant endDate) {
		this.endDate = endDate;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
