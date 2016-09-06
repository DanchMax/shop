package ua.form;

import ua.entity.Aging;
import ua.entity.Brand;
import ua.entity.Category;
import ua.entity.Country;
import ua.entity.Korzina;
import ua.entity.Perman;
import ua.entity.Size;
import ua.entity.Star;

public class ItemForm {

	private int id;

	private String name;

	private int price;

	private Aging aging;

	private Brand brand;

	private Category category;

	private Country country;

	private Perman perman;

	private Size size;

	private Star star;

	private Korzina korzina;

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

	public Aging getAging() {
		return aging;
	}

	public void setAging(Aging aging) {
		this.aging = aging;
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

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}

	public Korzina getKorzina() {
		return korzina;
	}

	public void setKorzina(Korzina korzina) {
		this.korzina = korzina;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
