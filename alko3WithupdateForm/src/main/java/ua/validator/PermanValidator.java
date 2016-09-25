package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Perman;
import ua.service.PermanService;

public class PermanValidator implements Validator {

	private final PermanService permanService;

	public PermanValidator(PermanService permanService) {
		this.permanService = permanService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Perman.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Perman perman = (Perman) target;
		if (perman.getId() == 0)
			if (permanService.findByPerman(perman.getPerman()) != null) {
				errors.rejectValue("perman", "",
						"Perman  name already exists");
			}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "perman", "",
				"Can`t be empty");
	}
}
