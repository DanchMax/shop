package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Brand;
import ua.service.BrandService;

public class BrandValidator implements Validator {

	private final BrandService brandService;

	public BrandValidator(BrandService brandService) {
		this.brandService = brandService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Brand.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Brand form = (Brand) target;
		if (form.getId() == 0)
			if (brandService.findByBrand(form.getBrand()) != null) {
				errors.rejectValue("brand", "", "Brand  name already exists");
			}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", "",
				"Can`t be empty");
	}

}
