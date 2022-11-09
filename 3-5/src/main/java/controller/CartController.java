package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import dao.ItemDAO;
import exception.LoginRequiredException;
import model.Cart;
import model.Item;
import model.ItemSet;
import model.User;

@Controller
public class CartController {

	@Autowired
	private ItemDAO itemDao;
	
	@RequestMapping(value="/cart/cartConfirm.html")
	public ModelAndView confirm(HttpSession session) {
		/* 로그인 확인 */
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser == null) { //로그인 안한 경우 예외를 발생시킴
			throw new LoginRequiredException("로그인이 필요합니다.");
		}
		/*----*/
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) cart = new Cart();
		session.setAttribute("CART_KEY", cart);
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("cart", cart);
		//User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null)
			mav.addObject("loginUser", loginUser);
		return mav;
	}
	
	@RequestMapping(value="/cart/cartClear.html")
	public ModelAndView clear(HttpSession session) {
		/* 로그인 확인 */
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser == null) { //로그인 안한 경우 예외를 발생시킴
			throw new LoginRequiredException("로그인이 필요합니다.");
		}
		/*----*/
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) cart = new Cart();
		cart.clearAll();
		ModelAndView mav = new ModelAndView("cart/cart");
		//User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null)
			mav.addObject("loginUser", loginUser);
		mav.addObject("message", "카트를 비웠습니다.");
		return mav;
	}
	
	@RequestMapping(value="/cart/cartAdd.html")
	public ModelAndView add(Integer itemId, Integer quantity, HttpSession session) {
		/* 로그인 확인 */
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser == null) { //로그인 안한 경우 예외를 발생시킴
			throw new LoginRequiredException("로그인이 필요합니다.");
		}
		/* 장바구니 담기 */
		Item item = this.itemDao.findById(itemId);
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) cart = new Cart();
		ItemSet is = new ItemSet(item, quantity);
		cart.push(is); //장바구니에 ItemSet 담음
		session.setAttribute("CART_KEY", cart); //장바구니를 세션에 저장
		/* 페이지 이동 */
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("loginUser",loginUser); //menu_header.jsp로 전달
		mav.addObject("message", item.getItemName()+"을 "+quantity+"개 카트에 담았습니다."); //cart.jsp로 전달
		mav.addObject("cart", cart); //cart.jsp로 전달
		return mav;
		
	}
}
