package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Aging;
import ua.service.AgingService;

public class AgingValidator implements Validator
{

	private final AgingService agingService;
	
	public AgingValidator(AgingService agingService){
		this.agingService=agingService;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Aging.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Aging aging= (Aging) target;
		if(aging.getId()==0)if(agingService.findByName(aging.getName())!=null){
			errors.rejectValue("name", "", "Aging already exists");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
	}

}
