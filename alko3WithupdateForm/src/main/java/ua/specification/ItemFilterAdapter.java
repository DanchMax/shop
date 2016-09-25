package ua.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.Item;
import ua.form.ItemFilterForm;

public class ItemFilterAdapter  implements Specification<Item> {

	private String search = "";

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

}
