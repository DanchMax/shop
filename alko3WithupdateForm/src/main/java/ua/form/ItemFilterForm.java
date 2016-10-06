package ua.form;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ItemFilterForm {

	private String search = "";
	
	private String min = "";

	private String max = "";

	private int minInt = 0;

	private int maxInt = 0;

	private static final Pattern p = Pattern.compile("^[0-9]{1,9}$");

	private List<Integer> brandIds = new ArrayList<>();

	private List<Integer> countryIds = new ArrayList<>();
	private List<Integer> categoryIds = new ArrayList<>();
	private List<Integer> permanIds = new ArrayList<>();
	private List<Integer> sizeIds = new ArrayList<>();

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

	public List<Integer> getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(List<Integer> brandIds) {
		this.brandIds = brandIds;
	}

	public List<Integer> getCountryIds() {
		return countryIds;
	}

	public void setCountryIds(List<Integer> countryIds) {
		this.countryIds = countryIds;
	}

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public List<Integer> getPermanIds() {
		return permanIds;
	}

	public void setPermanIds(List<Integer> permanIds) {
		this.permanIds = permanIds;
	}

	public List<Integer> getSizeIds() {
		return sizeIds;
	}

	public void setSizeIds(List<Integer> sizeIds) {
		this.sizeIds = sizeIds;
	}
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
