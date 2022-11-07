package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDAO;
import model.Item;
import model.User;

@Controller
public class IndexController {
	@Autowired
	private ItemDAO itemDao;
	
	@RequestMapping
	public ModelAndView handle(HttpSession session) {
		List<Item> itemList = this.itemDao.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", itemList); //index.jsp전달
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null) { //로그인한 경우
			mav.addObject("loginUser",loginUser); //menu_header.jsp전달
		}
		return mav;
	}
}
