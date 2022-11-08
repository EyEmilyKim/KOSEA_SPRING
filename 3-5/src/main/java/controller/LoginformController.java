package controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginformController {
	@Autowired
	private UserDAO userDao;
	@Autowired
	private LoginValidator loginValidator;
	
	@ModelAttribute
	public User getUser() {
		return new User();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String setUp() {
		return "loginform/login"; //jsp이름(WEB-INF/jsp/loginform/login.jsp)
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView login(User user, BindingResult br, HttpSession session) {
		this.loginValidator.validate(user, br);
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) { //폼체크 에러 발생한 경우
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		User loginUser = (User)this.userDao.getUser(user);
		if(loginUser != null) { //로그인 성공
			mav.setViewName("loginform/loginSuccess");
			mav.addObject("loginUser", loginUser);
			session.setAttribute("USER_KEY", loginUser);
		}else { //로그인 실패
			br.reject("error.login.user"); //"ID와 암호를 확인하세요."
			mav.getModel().putAll(br.getModel());
		}
		return mav;
	}
	
}
