package util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class UserEntryValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		User user = (User)target;
		if(! StringUtils.hasLength(user.getUserId())) {
			errors.rejectValue("userId", "error.required.user");
		}
		if(! StringUtils.hasLength(user.getPassword())) {
			errors.rejectValue("password", "error.required.user");
		}
		if(! StringUtils.hasLength(user.getUserName())) {
			errors.rejectValue("userName", "error.required.user");
		}
		if(! StringUtils.hasLength(user.getAddress())) {
			errors.rejectValue("address", "error.required.user");
		}
		if(! StringUtils.hasLength(user.getEmail())) {
			errors.rejectValue("email", "error.required.user");
		}
		if(! StringUtils.hasLength(user.getBirthday())) {
			errors.rejectValue("birthday", "error.required.user");
		}
		if( user.getBirthday().length() != 8) { //생년월일의 길이가 8이 아닌 경우
			errors.rejectValue("birthday", "typeMistmatch.user");
		}
		if(errors.hasErrors()) {
			errors.reject("error.input.user");
		}
	}

}
