package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DAO.ItemDAO;
import model.Item;

@Controller
public class DetailController {
	private ItemDAO itemDao;

	public void setItem(ItemDAO item) {
		this.itemDao = item;
	}

	@RequestMapping
	public ModelAndView detail(Integer itemId) {
		Item item = itemDao.findById(itemId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", item);
		mav.setViewName("detail");
		return mav;
	}
}
