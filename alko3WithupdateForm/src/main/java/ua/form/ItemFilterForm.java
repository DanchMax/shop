package ua.form;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

import ua.entity.Brand;
import ua.entity.Category;
import ua.entity.Country;
import ua.entity.Perman;
import ua.entity.Size;

public class ItemFilterForm {

	private String search = "";
	
	private String min = "";

	private String max = "";

	private int minInt = 0;

	private int maxInt = 0;

	private static final Pattern p = Pattern.compile("^[0-9]{1,9}$");

	private List<Brand> brandIds = new ArrayList<>();

	private List<Country> countryIds = new ArrayList<>();
	private List<Category> categoryIds = new ArrayList<>();
	private List<Perman> permanIds = new ArrayList<>();
	private List<Size> sizeIds = new ArrayList<>();

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		if(p.matcher(min).matches()) minInt = Integer.valueOf(min);
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		if(p.matcher(max).matches()) maxInt = Integer.valueOf(max);
		this.max = max;
	}

	public int getMinInt() {
		return minInt;
	}

	public void setMinInt(int minInt) {
		this.minInt = minInt;
	}

	public int getMaxInt() {
		return maxInt;
	}

	public void setMaxInt(int maxInt) {
		this.maxInt = maxInt;
	}

	public List<Brand> getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(List<Brand> brandIds) {
		this.brandIds = brandIds;
	}

	public List<Country> getCountryIds() {
		return countryIds;
	}

	public void setCountryIds(List<Country> countryIds) {
		this.countryIds = countryIds;
	}

	public List<Category> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Category> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public List<Perman> getPermanIds() {
		return permanIds;
	}

	public void setPermanIds(List<Perman> permanIds) {
		this.permanIds = permanIds;
	}

	public List<Size> getSizeIds() {
		return sizeIds;
	}

	public void setSizeIds(List<Size> sizeIds) {
		this.sizeIds = sizeIds;
	}
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
