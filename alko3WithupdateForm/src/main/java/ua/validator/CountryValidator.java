package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Country;
import ua.service.CountryService;

public class CountryValidator implements Validator {

	private final CountryService countryService;

	public CountryValidator(CountryService countryService) {
		this.countryService = countryService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Country.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Country form = (Country) target;
		if (form.getId() == 0)
			if (countryService.findByCountry(form.getCountry()) != null) {
				errors.rejectValue("country", "",
						"Country  name already exists");
			}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "",
				"Can`t be empty");
	}

}
