package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import model.Notice;

@Controller
public class NoticeController {
	@Autowired
	private NoticeDao noticeDao;
	
	@RequestMapping(value="/notice/noticeInput.html", method=RequestMethod.POST)
	public ModelAndView write(@Valid Notice notice, BindingResult br, HttpSession session) {
		String id = (String) session.getAttribute("MANAGER");
		ModelAndView mav = new ModelAndView("home/template"); 
		if(br.hasErrors()) {
			mav.addObject("BODY", "noticeInput.jsp");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		notice.setWriter(id); //작성자 설정
		noticeDao.putNotice(notice); //공지글 삽입
		return new ModelAndView("redirect:/read/readNotice.html"); //공지글 목록으로 매핑
	}
	
	@RequestMapping(value="/notice/noticeInput.html", method=RequestMethod.GET)
	public ModelAndView input() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject(new Notice()); //객체주입
		mav.addObject("BODY", "noticeInput.jsp");
		return mav;
	}
	
	@RequestMapping(value="/notice/detail.html", method=RequestMethod.GET)
	public ModelAndView detail(Integer SEQ) {
		Notice notice = noticeDao.getDetail(SEQ);
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject(notice);
		mav.addObject("BODY", "noticeDetail.jsp");
		return mav;
	}
	
	
	@RequestMapping(value="/notice/modify.html", method=RequestMethod.POST)
	public ModelAndView modify(Notice notice, String BTN) {
		if(BTN.equals("삭 제")) {
			this.noticeDao.deleteNotice(notice.getSeqno());
		}else if(BTN.equals("수 정")) {
			this.noticeDao.updateNotice(notice);
		}
		return new ModelAndView("redirect:/read/readNotice.html");
	}
	
	
}
