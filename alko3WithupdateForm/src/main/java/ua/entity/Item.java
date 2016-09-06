package ua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private int price;

	@ManyToOne(fetch = FetchType.LAZY)
	private Brand brand;
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	@ManyToOne(fetch = FetchType.LAZY)
	private Country country;
	@ManyToOne(fetch = FetchType.LAZY)
	private Perman perman;
	@ManyToOne(fetch = FetchType.LAZY)
	private Size size;

	@ManyToOne(fetch = FetchType.LAZY)
	private Korzina korzina;

	public Korzina getKorzina() {
		return korzina;
	}

	public void setKorzina(Korzina korzina) {
		this.korzina = korzina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Perman getPerman() {
		return perman;
	}

	public void setPerman(Perman perman) {
		this.perman = perman;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
