package controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import dao.ItemDAO;
import model.Item;
import model.User;

@Controller
public class DetailController {
	@Autowired
	private ItemDAO itemDao;
	
	@RequestMapping
	public ModelAndView detail(Integer itemId, HttpSession session) {
		Item item = (Item)this.itemDao.findById(itemId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item",item); //detail.jsp 로 전달
		User loginUser = (User)session.getAttribute("UER_KEY");
		if(loginUser != null) 
			mav.addObject("loginUser",loginUser);
		return mav;
	}
}
