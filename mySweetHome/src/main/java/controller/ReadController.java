package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.BbsDao;
import dao.NoticeDao;
import model.Bbs;
import model.Notice;

@Controller
public class ReadController {
	@Autowired
	private BbsDao bbsDao;
	@Autowired
	private NoticeDao noticeDao;
	
	@RequestMapping(value="/read/entryBBS.html")
	public ModelAndView entryBBS(@Valid Bbs bbs, BindingResult br, HttpSession session) {
		String id = (String) session.getAttribute("LOGIN");
		ModelAndView mav = new ModelAndView("home/template");
		if(br.hasErrors()) {
			mav.addObject("BODY", "bbsInput.jsp");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		Integer max = this.bbsDao.getMaxSeqno();
		if(max == null) max = 1;
		else max = max + 1;
		bbs.setSeqno(max); //글번호 설정
		bbs.setWriter(id); //작성자 설정
		bbsDao.putBBS(bbs); //DB에 삽입
		return new ModelAndView("redirect:/read/read.html");
	}
	
	@RequestMapping(value="/read/putBBS.html")
	public ModelAndView putBBS() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("bbs", new Bbs());
		mav.addObject("BODY", "bbsInput.jsp");
		return mav;				
	}
	
	@RequestMapping(value="/read/detail.html")
	public ModelAndView detail(Integer NO) {
		Bbs detail = bbsDao.getBBSDetail(NO);
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BBS", detail);
		mav.addObject("BODY", "bbsDetail.jsp");
		return mav;
	}
	
	@RequestMapping(value="/read/read.html")
	public ModelAndView read(Integer pageNo) {
		int currentPage = 0;
		if(pageNo == null) currentPage = 1;
		else currentPage = pageNo;
		List<Bbs> bbsList = bbsDao.readBBS(currentPage);
		Integer totalCount = bbsDao.getBBSCount();
		int pageCount = totalCount / 5;
		if(totalCount % 5 > 0) pageCount++;
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("bbsList", bbsList);
		mav.addObject("pageCount", pageCount);
		mav.addObject("BODY", "bbsList.jsp");
		return mav;
	}
	
	@RequestMapping(value="/read/readNotice.html")
	public ModelAndView readNotice(Integer pageNo) {
		int currentPage = 0;
		if(pageNo == null) currentPage = 1;
		else currentPage = pageNo;
		int start = (currentPage - 1)* 5;
		int end = ((currentPage - 1)* 5) + 6;
		List<Notice> noticeList = noticeDao.getAllNotice(currentPage);
		Integer totalCount = noticeDao.getNoticeCount();
		if(end > totalCount) end = totalCount + 1;
		int pageCount = totalCount / 5;
		if(totalCount % 5 > 0) pageCount++;
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("START", start+1); // 
		mav.addObject("END", end-1); //
		mav.addObject("TOTAL", totalCount); //전체 게시글 수 
		mav.addObject("PAGES", pageCount); //페이지 수 
		mav.addObject("LIST", noticeList); //게시글 목록
		mav.addObject("BODY", "noticeList.jsp"); 
		return mav;
	} 
}
