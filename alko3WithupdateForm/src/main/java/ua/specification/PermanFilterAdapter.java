package ua.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.Perman;
import ua.form.PermanFilterForm;

public class PermanFilterAdapter implements Specification<Perman> {

	private String search = "";

	public PermanFilterAdapter(PermanFilterForm form) {
		search = form.getSearch();
	}

	@Override
	public Predicate toPredicate(Root<Perman> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (query.getResultType() != Long.class
				&& query.getResultType() != long.class) {
			// root.fetch("ingredient");
			// root.fetch("measuringSystem");
			// query.distinct(true);
		}
		Expression<String> exp = root.get("perman");
		return cb.like(cb.upper(exp), search.toUpperCase() + "%");
	}
}
