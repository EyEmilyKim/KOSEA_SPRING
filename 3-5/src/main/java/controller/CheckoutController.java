package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import exception.LoginRequiredException;
import model.Cart;
import model.ItemSet;
import model.User;

@Controller
public class CheckoutController {
	@RequestMapping
	public ModelAndView checkout(HttpSession session) {
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser == null) { //로그인 안한 경우
			throw new LoginRequiredException("로그인이 필요합니다.");
		}
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null || cart.isEmpty()) { //카트가 빈 경우
			throw new CartEmptyException("카트가 비어있습니다.");
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginUser", loginUser);
		ArrayList<ItemSet> itemList = (ArrayList)cart.getItemList();
		mav.addObject("itemList", itemList);
		return mav;
	} 
}
