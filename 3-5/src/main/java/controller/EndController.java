package controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import exception.CartEmptyException;
import exception.LoginRequiredException;
import model.Cart;
import model.User;
import service.SaleCatalog;

@Controller
public class EndController {
	@Autowired
	private SaleCatalog saleCatalog;
	
	@RequestMapping
	public ModelAndView end(HttpSession session) {
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser == null)
			throw new LoginRequiredException("로그인이 필요합니다.");
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null || cart.isEmpty())
			throw new CartEmptyException("카트가 비어있습니다.");
		//DB에 매출정보 삽입
		this.saleCatalog.checkout(loginUser, cart);
		cart.clearAll(); //구매 종료 -> 장바구니 비움
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginUser", loginUser);
		return mav;
	}
}
