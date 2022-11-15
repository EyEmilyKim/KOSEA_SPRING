package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;

@Controller
public class IdcheckController {
	@Autowired
	private UserDao userDao;
	@RequestMapping(value="/idcheck/idcheck.html")
	public ModelAndView idCheck(String USER_ID) {
		ModelAndView mav = new ModelAndView("home/idCheck");
		String id = this.userDao.getId(USER_ID); //DB에서 계정 검색
		if(id != null) { //해당 계정이 이미 존재하는 경우
			mav.addObject("DUP", "YES");
		}else { //계정이 존재하지 않는 경우 (즉, 사용가능)
			mav.addObject("DUP", "NO");
		}
		mav.addObject("ID", USER_ID);
		return mav;
	}
}
