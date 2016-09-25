package ua.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.form.ItemForm;
import ua.service.ItemService;

public class ItemFormValidator implements Validator {

	private final ItemService itemService;

	public ItemFormValidator(ItemService itemService) {
		this.itemService = itemService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return ItemForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ItemForm form = (ItemForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Item name can't be empty");
		if(form.getId()==0)if(itemService.findByName(form.getName())!=null){
			errors.rejectValue("name", "", "Item name already exists");
		}
		Pattern p = Pattern.compile("^[0-9]{1,5}");
		Matcher m = p.matcher(form.getPrice());
		if(!m.matches()){
			errors.rejectValue("price", "", "Price format is min 1 - max 10000");
		}
	}


}
