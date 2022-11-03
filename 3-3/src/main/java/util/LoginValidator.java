package util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class LoginValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	} //(콜백 메서드) 검증 대상이 되는 객체를 설정함.

	public void validate(Object target, Errors errors) {
		User user = (User)target; //Object로 받은 객체(UserId&password 들어있음)를 User 타입으로 바꿔줌 
		if(! StringUtils.hasLength(user.getUserId()) ) { //UserId 문자열에 길이가 없다면
			//에러 메세지 출력(항목 에러 메세지)
			errors.rejectValue("userId", "error.required");
		}
		if(! StringUtils.hasLength(user.getPassword()) ) { //Password 문자열에 길이가 없다면
			//에러 메세지 출력
			errors.rejectValue("password", "error.required");
		}
		if(errors.hasErrors()) {
			errors.reject("error.input.user"); //폼 에러 메세지 출력
		}
	} //폼체크 할 때 이 메서드를 호출

}
