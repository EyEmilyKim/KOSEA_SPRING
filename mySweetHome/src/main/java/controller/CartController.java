package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Member;

@Controller
public class CartController {

	@RequestMapping(value="/cart/addCart.html", method=RequestMethod.GET)
	public ModelAndView addCart(String CODE, HttpSession session) {
		String id = (String) session.getAttribute("LOGIN");
		if(id == null) { //로그인 안한 경우
			ModelAndView mav = new ModelAndView("home/loginCart");
			mav.addObject(new Member());
			mav.addObject("message", "상품을 담으시려면 로그인이 필요합니다.");
			return mav;
		}else { //로그인 한 경우

			ModelAndView mav = new ModelAndView("");
			return mav;
		}
		
	}
}
