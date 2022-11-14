package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Member;

@Controller
public class HomeController {
	@RequestMapping(value="home/userentry.html")
	public ModelAndView entry() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY", "userEntry.jsp");
		mav.addObject(new Member());
		return mav;
	}
	@RequestMapping(value="/home/intro.html")
	public ModelAndView intro(String BODY) {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY",BODY); //template.jsp의 <c:when test="${BODY != null }">로 전달됨
		return mav;
	}
	
	@RequestMapping(value="/home/template.html")
	public ModelAndView template() {
		ModelAndView mav = new ModelAndView("home/template");
		return mav;
	}
}
