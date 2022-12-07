package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginDao;
import model.Member;

@Controller
public class LoginController {
	@Autowired
	private LoginDao loginDao;

	@RequestMapping(value="/login/template.html")
	public ModelAndView loginSetup(@Valid Member member, BindingResult br, HttpSession session) {
		ModelAndView mav = new ModelAndView("home/template");
		if(br.hasErrors()) {
			System.out.println("폼 에러 발생");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		String pwd = loginDao.getPwd(member.getId());
		if(pwd == null) { //pwd 없음(즉 계정이 존재하지 않음)
			mav.addObject("NOID","YES");
		}else { //pwd 검색됨
			if(pwd.equals(member.getPwd())) { //암호 일치, 로그인 성공!
				//일반 사용자인 경우, 관리자인 경우 구분
				if(member.getId().equals("manager")) {
					session.setAttribute("MANAGER", member.getId());
				}else {
					session.setAttribute("LOGIN", member.getId());
				}
			}else { //암호 불일치
				mav.addObject("NOPWD","YES");
			}
		}
		mav.addObject("BODY", "loginResult.jsp");
		return mav;
	}
	@RequestMapping(value="/login/login.html")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("home/login");
		//mav.addObject(new Member()); //객체 주입
		request.setAttribute("member",	new Member());
		return mav;
	}
}
