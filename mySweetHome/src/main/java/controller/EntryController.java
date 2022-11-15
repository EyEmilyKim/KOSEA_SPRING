package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
import model.Member;

@Controller
public class EntryController {
	@Autowired
	private UserDao userDao;
	@RequestMapping(value="/entry/entry.html")
	public ModelAndView entry(Member user) {
		ModelAndView mav = new ModelAndView("home/template");
		userDao.entryUser(user); //DB에 삽입
		mav.addObject("BODY", "userEntryResult.jsp");
		return mav;
	}
	
}
