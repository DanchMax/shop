package ua.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.User;
import ua.service.UserService;

public class UserValidator implements Validator{

	private final UserService userService;

	public UserValidator(UserService userService) {
		this.userService = userService;
	}

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "",
				"Username can't be empty");
		if(user.getId()==0)if (userService.findByLogin(user.getLogin()) != null) {
			errors.rejectValue("username", "",
					"User with this username already exists");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "",
				"Email can't be empty");
		if(user.getId()==0)if (userService.findByMail(user.getMail()) != null) {
			errors.rejectValue("email", "", "User with this email"
					+ " already exists");
		}
		Pattern p = Pattern.compile("^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
		Matcher m = p.matcher(user.getMail());
		if(!m.matches()){
			errors.rejectValue("email", "", "Wrong email format (example: emailname@somemail.com)");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "",
				"Password can't be empty");	
		Pattern p1 = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,15}$");
		Matcher m1 = p1.matcher(user.getPassword());
		if(!m1.matches()){
			errors.rejectValue("password", "", "Password must be at least 4 characters, no more than 15 characters, and must include at least one upper case letter, one lower case letter, and one numeric digit.");
		}
	}
}
