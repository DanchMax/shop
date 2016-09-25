package ua.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.Korzina;
import ua.form.KorzinaFilterForm;

public class KorzinaFilterAdapter implements Specification<Korzina>{
	private String search = "";

	public KorzinaFilterAdapter(KorzinaFilterForm form) {
		search = form.getSearch();
	}

	@Override
	public Predicate toPredicate(Root<Korzina> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (query.getResultType() != Long.class
				&& query.getResultType() != long.class) {
			// root.fetch("ingredient");
			// root.fetch("measuringSystem");
			// query.distinct(true);
		}
		Expression<String> exp = root.get("korzina");
		return cb.like(cb.upper(exp), search.toUpperCase() + "%");
	}

}
