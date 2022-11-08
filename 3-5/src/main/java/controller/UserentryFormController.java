package controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import dao.UserDAO;
import model.User;
import util.UserEntryValidator;

@Controller
public class UserentryFormController {
	@Autowired
	private UserDAO userDao;
	@Autowired
	private UserEntryValidator userEntryValidator;
	@Autowired
	private MessageSource messageSource;
	
	@ModelAttribute
	public User setUp() {
		User user = new User();
		MessageSourceAccessor msa = new MessageSourceAccessor(this.messageSource);
		user.setUserId(msa.getMessage("user.userId.default")); //디폴트메세지 추출
		user.setUserName(msa.getMessage("user.userName.default")); //디폴트메세지 추출
		return user;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String entryForm() {
		return "userentryform/userEntry";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView toEntry(User user, BindingResult br, HttpSession session) {
		this.userEntryValidator.validate(user, br);
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			this.userDao.create(user); //DB에 삽입
			session.setAttribute("USER_KEY", user); //회원가입 성공시 바로 로그인 상태로
			mav.setViewName("userentryform/userEntrySuccess");
			mav.addObject("user",user);
		}catch(DataIntegrityViolationException e) {
			br.reject("");
			mav.getModel().putAll(br.getModel());
		}
		return mav;
	}
	
}
