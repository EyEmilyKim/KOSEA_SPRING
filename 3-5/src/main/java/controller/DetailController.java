package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import dao.ItemDAO;

@Controller
public class DetailController {
	@Autowired
	private ItemDAO itemDao;
	
	@RequestMapping
	public ModelAndView detail(Integer itemId) {
		return null;
	}
}
