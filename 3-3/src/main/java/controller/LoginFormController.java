package controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDAO;
import model.User;
import util.LoginValidator;

@Controller
public class LoginFormController {
	private UserDAO userDao;
	private LoginValidator loginValidator;
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	public void setLoginValidator(LoginValidator loginValidator) {
		this.loginValidator = loginValidator;
	}
	
	@ModelAttribute
	public User setUp() {
		return new User();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		return "login"; //뷰이름을 리턴
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView toLogin(User user, BindingResult br) {
		this.loginValidator.validate(user, br); //폼 체크
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) { //에러가 있다면
			//ModelAndView에 BindingResult에 있는 에러메세지를 저장한다.
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			User loginUser = this.userDao.getUser(user);
			if(loginUser != null) { //로그인 성공
				mav.setViewName("loginSuccess"); //성공페이지로 이동
				mav.addObject("loginUser", loginUser); //조회결과 저장-> 환영~${}님
				return mav;
			}else { //로그인 실패
				br.reject("error.login.user"); //에러 메시지 만들어서
				mav.getModel().putAll(br.getModel()); //mav에 저장
				return mav;
			}
		}
		catch(EmptyResultDataAccessException e) {
			br.reject("error.login.user");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
	}
}
