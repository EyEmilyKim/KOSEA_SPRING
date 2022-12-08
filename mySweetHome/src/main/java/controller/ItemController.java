package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Item;

@Controller
public class ItemController {
	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping(value="/item/entry.html", method=RequestMethod.GET)
	public ModelAndView entry() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject(new Item()); //객체 주입
		mav.addObject("BODY", "itemInput.jsp");
		return mav;
	}
	
	@RequestMapping(value="/item/codecheck.html", method=RequestMethod.GET)
	public ModelAndView codecheck(String CODE) {
		ModelAndView mav = new ModelAndView("home/codeCheck");
		Integer cnt = itemDao.checkItemCode(CODE);
		if(cnt > 0) mav.addObject("DUP","YES");
		else mav.addObject("DUP","NO");
		mav.addObject("CODE", CODE);
		return mav;
	}
	
	@RequestMapping(value="/item/register.html", method=RequestMethod.POST)
	public ModelAndView register(@Valid Item item, BindingResult br) {
		ModelAndView mav = new ModelAndView("home/template");
		if(br.hasErrors()) {
			mav.addObject("BODY", "itemInput.jsp");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		this.itemDao.putItem(item); //상품정보 등록
		return new ModelAndView("redirect:/read/readItems.html");
		
		
	}
}
