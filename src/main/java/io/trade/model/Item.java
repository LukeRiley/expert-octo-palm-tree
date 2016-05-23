package io.trade.model;

import javax.persistence.*;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "image", nullable = false)
	private String image;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@OneToOne
	private Category category;
	
	public Item(String name, String image, String description, Category category) {
		super();
		this.name = name;
		this.image = image;
		this.description = description;
		this.category = category;
		
		if(description == null)
			this.description = "";
	}

	public Item() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		if(description == null)
			this.description = "";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
