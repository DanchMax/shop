package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Role;
import ua.service.RoleService;

public class RoleValidator implements Validator {

	private final RoleService roleService;

	public RoleValidator(RoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Role.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Role role = (Role) target;
		if (role.getId() == 0)
			if (roleService.findByRole(role.getRole()) != null) {
				errors.rejectValue("role", "",
						"Role  name already exists");
			}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "",
				"Can`t be empty");
	}
}
