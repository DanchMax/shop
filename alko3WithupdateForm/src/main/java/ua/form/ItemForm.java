package ua.form;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.Brand;
import ua.entity.Category;
import ua.entity.Country;
import ua.entity.Korzina;
import ua.entity.Perman;
import ua.entity.Size;

public class ItemForm {

	private int id;

	private String name;

	private String price;

	private Brand brand;

	private Category category;

	private Country country;

	private Perman perman;

	private Size size;

	private Korzina korzina;

	private int version;

	private MultipartFile file;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
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
