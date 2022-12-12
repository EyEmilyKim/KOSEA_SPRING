package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Cart;
import model.CartItem;
import model.Member;

@Controller
public class CartController {
	@Autowired
	private Cart cart;
	
	@RequestMapping(value="/cart/addCart.html", method=RequestMethod.GET)
	public ModelAndView addCart(String CODE, HttpSession session) {
		String id = (String) session.getAttribute("LOGIN");
		if(id == null) { //로그인 안한 경우
			ModelAndView mav = new ModelAndView("home/loginCart");
			mav.addObject(new Member());
			mav.addObject("message", "상품을 담으시려면 로그인이 필요합니다.");
			return mav;
		}else { //로그인 한 경우
			ModelAndView mav = new ModelAndView("home/addCartResult");
			Cart cart = (Cart) session.getAttribute("CART");
			if(cart == null) cart = this.cart;
			cart.setId(id);
			cart.addCart(CODE, 1);
			session.setAttribute("CART", cart);
			mav.addObject("CODE",CODE);
			return mav;
		}
	}
	
	@RequestMapping(value="/cart/show.html", method=RequestMethod.GET)
	public ModelAndView show(HttpSession session) {
		String id = (String) session.getAttribute("LOGIN");
		Cart cart = (Cart) session.getAttribute("CART");
		ModelAndView mav = new ModelAndView("home/template");
		ArrayList<CartItem> cartItemList = new ArrayList<CartItem>();
		if(cart != null) { //장바구니가 있는 경우
			//codeList에 있는 상품번호로 가격, 이름을 검색한다.
			int totalAmount = 0; //총액을 위한 변수 선언
			ArrayList<String> codeList = cart.getCodeList();
			ArrayList<Integer> numList = cart.getNumList();
			for(int cnt=0; cnt < codeList.size(); cnt++) {
				String code = codeList.get(cnt);
				CartItem ci = cart.getCartItem(code);
				ci.setNum(numList.get(cnt)); //갯수
				totalAmount = totalAmount + (ci.getPrice() * ci.getNum());
				ci.setId(id); //계정
				cartItemList.add(ci);
			}
			mav.addObject("TOTAL", totalAmount);
			mav.addObject("CARTLIST", cartItemList);
		}else { //장바구니가 없는 경우
			mav.addObject("SIZE", "NO");
		}
		mav.addObject("BODY", "cartList.jsp");
		return mav;
	}
	
	@RequestMapping(value="cart/modify.html", method=RequestMethod.POST)
	public ModelAndView modify(String CODE, Integer NUM, String BTN, HttpSession session) {
		String id = (String) session.getAttribute("LOGIN");
		Cart cart = (Cart) session.getAttribute("CART");
		if(BTN.equals("수정")) {
			
		}else if(BTN.equals("삭제")) {
			cart.deleteItem(CODE, id);
		}
		return new ModelAndView("redirect:/cart/show.html");
	}
}
