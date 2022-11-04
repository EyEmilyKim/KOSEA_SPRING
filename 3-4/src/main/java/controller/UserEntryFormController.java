package controller;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
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
public class UserEntryFormController {
	private UserDAO userDao;
	private UserEntryValidator userEntryValidator;
	private MessageSource messageSource;
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	public void setUserEntryValidator(UserEntryValidator userEntryValidator) {
		this.userEntryValidator = userEntryValidator;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@ModelAttribute
	public User setUp() {
		User user = new User();
		MessageSourceAccessor msa = new MessageSourceAccessor(this.messageSource);
		user.setUserId(msa.getMessage("user.userId.default"));
		user.setUserName(msa.getMessage("user.userName.default"));
		return user;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String toUserEntry() {
		return "userEntry";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView toEntry(User user, BindingResult br) {
		this.userEntryValidator.validate(user, br);
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		return mav;
	}
}
