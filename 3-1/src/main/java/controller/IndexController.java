package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import DAO.ItemDAO;
import model.Item;

public class IndexController implements Controller {
	private ItemDAO itemDao;
	public void setItemDao(ItemDAO itemDao) {
		this.itemDao = itemDao;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<Item> list = itemDao.findAll();
		mav.addObject("itemList",list); //DB 조회결과를 ModelAndView에 저장.
		mav.setViewName("/WEB-INF/jsp/index.jsp"); //JSP 이름을 ModelAndView에 저장.
		return mav;
	} //이 메서드는 콜백메서드(자동으로 호출되는 메서드)이다. 

}
