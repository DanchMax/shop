package ua.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.User;
import ua.form.UserFilterForm;

public class UserFilterAdapter implements Specification<User> {

	private String search = "";

	public UserFilterAdapter(UserFilterForm form) {
		search = form.getSearch();
	}

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (query.getResultType() != Long.class
				&& query.getResultType() != long.class) {
			 root.fetch("role");
			// root.fetch("measuringSystem");
			 query.distinct(true);
		}
		Expression<String> exp = root.get("user");
		return cb.like(cb.upper(exp), search.toUpperCase() + "%");
	}

}
