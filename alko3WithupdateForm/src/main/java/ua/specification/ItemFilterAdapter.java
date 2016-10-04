package ua.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Item;
import ua.form.ItemFilterForm;

public class ItemFilterAdapter  implements Specification<Item> {

	/*private String search = "";

	public ItemFilterAdapter(ItemFilterForm form) {
		search = form.getSearch();
	}

	@Override
	public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (query.getResultType() != Long.class
				&& query.getResultType() != long.class) {
			
			root.fetch("brand");
			root.fetch("category");
			root.fetch("country");
			root.fetch("perman");
			root.fetch("size");
			 query.distinct(true);
		}
		Expression<String> exp = root.get("name");
		return cb.like(cb.upper(exp), search.toUpperCase() + "%");
	}
*/
	
	private final ItemFilterForm form;
	
	private final List<Specification<Item>> filters = new ArrayList<>();

	public ItemFilterAdapter(ItemFilterForm form) {
		if (form != null) {
			this.form = form;
		} else {
			this.form = new ItemFilterForm();
		}
	}

	private void findByPrice(){
		if(form.getMinInt()!=0&&form.getMaxInt()!=0){
//			filters.add((root, query, cb)->cb.between(root.get("amount"), form.getMinInt(), form.getMaxInt()));
			filters.add((root, query, cb)->{
				Expression<Integer> exp = root.get("price");
				return cb.between(exp, form.getMinInt(), form.getMaxInt());
			});
		}else if(form.getMinInt()!=0){
			filters.add((root, query, cb)->{
				Expression<Integer> exp = root.get("price");
				return cb.ge(exp, form.getMinInt());
			});
		}else if(form.getMaxInt()!=0){
			filters.add((root, query, cb)->{
				Expression<Integer> exp = root.get("price");
				return cb.le(exp, form.getMaxInt());
			});
		}
	}
	
	private void findByBrand(){
		if(!form.getBrandIds().isEmpty()){
			filters.add((root, query, cb)->root.get("brand").in(form.getBrandIds()));
		}
	}
	
	private void findByCountry(){
		if(!form.getCountryIds().isEmpty()){
			filters.add((root, query, cb)->root.get("country").in(form.getCountryIds()));
		}
	}
	
	private void findByCategory(){
		if(!form.getCategoryIds().isEmpty()){
			filters.add((root, query, cb)->root.get("category").in(form.getCategoryIds()));
		}
	}
	
	private void findByPerman(){
		if(!form.getPermanIds().isEmpty()){
			filters.add((root, query, cb)->root.get("perman").in(form.getPermanIds()));
		}
	}
	
	private void findBySize(){
		if(!form.getSizeIds().isEmpty()){
			filters.add((root, query, cb)->root.get("size").in(form.getSizeIds()));
		}
	}
	
	
	@Override
	@Transactional
	public Predicate toPredicate(Root< Item> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (query.getResultType() != Long.class && query.getResultType() != long.class) {
			root.fetch("brand", JoinType.LEFT);
			root.fetch("country", JoinType.LEFT);
			root.fetch("category", JoinType.LEFT);
			root.fetch("perman", JoinType.LEFT);
			root.fetch("size", JoinType.LEFT);
			query.distinct(true);
		}
		findByBrand();
		findByPrice();
		findByCountry();
		findByCategory();
		findByPerman();
		findBySize();
		if(!filters.isEmpty()){
			Specifications<Item> spec = Specifications.where(filters.get(0));
			for(Specification<Item> s : filters.subList(1, filters.size())){
				spec = spec.and(s);
			}
			return spec.toPredicate(root, query, cb);
		}
		return null;
	}
}
